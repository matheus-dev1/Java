package br.com.matheus.spring.learning.matheuslearningjava18spring3.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    public static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    // O - Origem
    // D - Destino

    public static <O, D> D parseObject(O origin, Class<D> destiny) {
        return mapper.map(origin, destiny);
    }

    public static <O, D> List<D> parseListObject(List<O> listOrigin, Class<D> destiny) {
        List<D> listDestinyObjects = new ArrayList<>();

        for (O origin : listOrigin) {
            listDestinyObjects.add(mapper.map(origin, destiny));
        }

        return listDestinyObjects;
    }
}
