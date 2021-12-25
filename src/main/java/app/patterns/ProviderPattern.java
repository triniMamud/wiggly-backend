package app.patterns;


import app.repository.IGatosRepository;
import app.repository.IPerrosRepository;
import com.google.common.reflect.TypeToken;


import javax.annotation.Nonnull;
import javax.inject.Provider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProviderPattern
{
    private static final List<String> CLASS_NAMES = new ArrayList<>(){{
        add("IPerrosRepository");
        add("IGatosRepository");
    }};

    public static final Map<String, Provider<StrawManParameterizedClass>> PROVIDERS;

    static
    {
        final Map<String, Provider<StrawManParameterizedClass>> imb = new HashMap<>();
        for (final String cn : CLASS_NAMES)
        {
            switch (cn)
            {
                case "IPerrosRepository":
                    imb.put(cn, () -> new StrawManParameterizedClass<IPerrosRepository>() {});
                    break;
                case "IGatosRepository":
                    imb.put(cn, () -> new StrawManParameterizedClass<IGatosRepository>() {
                    });
                    break;
                default:
                    throw new IllegalArgumentException(String.format("%s is not a supported type " + CLASS_NAMES));
            }
        }
        PROVIDERS = imb;
    }

    static <T> void read(@Nonnull final StrawManParameterizedClass<T> smpc) { System.out.println(smpc.type.toString()); }
    //static <T> void getRepository(@Nonnull final StrawManParameterizedClass<T> smpc) { smpc.type; }


    static abstract class StrawManParameterizedClass<T>
    {
        final TypeToken<T> type = new TypeToken<T>(getClass()) {};

        @Override
        public String toString() { return type.getRawType().getCanonicalName(); }
    }

    /*public static void main(final String[] args)
    {
        for (final String cn : CLASS_NAMES)
        {
            read(PROVIDERS.get(cn).get());
        }
    }*/
}