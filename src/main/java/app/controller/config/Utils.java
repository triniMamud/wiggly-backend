package app.controller.config;

import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class Utils {

    /**
     * Private constructor to avoid class intantiation.
     */
    private Utils() {
    }

    /**
     * <p>Safely creates a {@link java.util.stream.Stream} from specified {@link java.util.Collection}. If
     * input is null returns with an empty <code>stream</code>, otherwise
     * returns with a stream representation of input without null objects.</p>
     * <pre>{@link java.util.Arrays#stream(Object[])}: Arrays.stream(Type
     * .values()).</pre>
     *
     * @param input collection to convert, can be empty or null.
     * @param <T> inferred type of input.
     *
     * @return an empty stream if input is null, otherwise a stream of input
     * without null objects.
     */
    public static <T> Stream<T> safeStream(final Collection<T> input) {
        return nonNull(input) ? input.stream().filter(Objects::nonNull) :
                Stream.empty();
    }

    /**
     * <p>Safely check a {@link Stream} from specified {@link Collection}. If
     * input is null or empty returns true, otherwise returns false.</p>
     * <pre>{@link java.util.Arrays#stream(Object[])}: Arrays.stream(Type
     * .values()).</pre>
     *
     * @param input collection to check, can be empty or null.
     * @param <T> inferred type of input.
     *
     * @return an true if input is null or empty, otherwise an false.
     */
    public static <T> boolean safeIsEmpty(final Collection<T> input) {
        return isNull(input) || input.stream().allMatch(Objects::isNull);
    }

    /**
     * <p>Safely check a {@link Stream} from specified {@link Collection}. If
     * input is null or empty returns false, otherwise returns true.</p>
     * <pre>{@link java.util.Arrays#stream(Object[])}: Arrays.stream(Type
     * .values()).</pre>
     *
     * @param input collection to check, can be empty or null.
     * @param <T> inferred type of input.
     *
     * @return an true if input is null or empty, otherwise an false.
     */
    public static <T> boolean safeIsNotEmpty(final Collection<T> input) {
        return !safeIsEmpty(input);
    }

    /**
     * Format OffsetDateTime to string with timezone.
     *
     * @param date the date
     * @param timezone the timezone
     * @param theFormatter the the formatter
     *
     * @return the string
     */
    public static String formatOffsetDate(
            OffsetDateTime date,
            String timezone,
            DateTimeFormatter theFormatter
    ) {
        return date
                .withOffsetSameInstant(ZoneOffset.of(timezone.replace("GMT", "")))
                .format(theFormatter);
    }

    /**
     * Check if the object has at least one field with information.
     * Using Class#getFields to get all the objects from the fields of the
     * class sent by parameter.
     * In case of being a subclass, the fields of the superclass are not
     * evaluated.
     *
     * @param object the object
     *
     * @return boolean
     * @throws IllegalAccessException the illegal access exception
     */
    public static boolean isEmpty(Object object) throws IllegalAccessException {
        for (Field field : object.getClass().getFields()) {
            if (field.get(object) != null) {
                return false;
            }
        }
        return true;
    }
}
