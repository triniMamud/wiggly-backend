package app.factory;

import app.model.MascotasEnum;
import app.repository.IGatosRepository;
import app.repository.IPerrosRepository;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

public class MascotaFactory <T>{

    @Autowired
    IPerrosRepository perrosRepository;
    @Autowired
    IGatosRepository gatosRepository;


    public T getRepository(MascotasEnum mascotasEnum, Class<T> type) {
        switch (mascotasEnum.name()){
            case "PERRO": return type.cast(perrosRepository);
            case "GATO": return (T) gatosRepository;
        }
        return null;
    }

    public Object getClass(MascotasEnum mascotasEnum, Class<T> type) {
        switch (mascotasEnum.name()){
            case "PERRO": return perrosRepository;
            case "GATO": return gatosRepository.getClass();
        }
        return null;
    }
}

public class ProviderPattern
{
    private static final List<String> CLASS_NAMES = ImmutableList.of("IPerrosRepository", "IGatosRepository");
    private static final Map<String, ServiceLoader.Provider<StrawManParameterizedClass>> PROVIDERS;

    static
    {
        final ImmutableMap.Builder<String, Provider<StrawManParameterizedClass>> imb = ImmutableMap.builder();
        for (final String cn : CLASS_NAMES)
        {
            switch (cn)
            {
                case "String":
                    imb.put(cn, new Provider<StrawManParameterizedClass>()
                    {
                        @Override
                        public StrawManParameterizedClass<String> get() { return new StrawManParameterizedClass<String>() {}; }
                    });
                    break;
                case "Integer":
                    imb.put(cn, new Provider<StrawManParameterizedClass>()
                    {
                        @Override
                        public StrawManParameterizedClass<Integer> get() { return new StrawManParameterizedClass<Integer>() {}; }
                    });
                    break;
                case "Boolean":
                    imb.put(cn, new Provider<StrawManParameterizedClass>()
                    {
                        @Override
                        public StrawManParameterizedClass<Integer> get() { return new StrawManParameterizedClass<Integer>() {}; }
                    });
                    break;
                default:
                    throw new IllegalArgumentException(String.format("%s is not a supported type %s", cn, Joiner.on(",").join(CLASS_NAMES)));
            }
        }
        PROVIDERS = imb.build();
    }

    static <T> void read(@Nonnull final StrawManParameterizedClass<T> smpc) { System.out.println(smpc.type.toString()); }

    static abstract class StrawManParameterizedClass<T>
    {
        final TypeToken<T> type = new TypeToken<T>(getClass()) {};

        @Override
        public String toString() { return type.getRawType().getCanonicalName(); }
    }

    public static void main(final String[] args)
    {
        for (final String cn : CLASS_NAMES)
        {
            read(PROVIDERS.get(cn).get());
        }
    }
}