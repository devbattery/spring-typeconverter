package hello.typeconverter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

class ConversionServiceTest {

    @DisplayName("컨버전 서비스로 적절한 컨버터를 찾을 수 있다.")
    @Test
    void conversion_service() {
        // given
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // when
        Integer result1 = conversionService.convert("10", Integer.class);
        String result2 = conversionService.convert(10, String.class);
        IpPort result3 = conversionService.convert("127.0.0.1:8080", IpPort.class);
        String result4 = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);

        // then
        assertThat(result1).isEqualTo(10);
        assertThat(result2).isEqualTo("10");
        assertThat(result3).isEqualTo(new IpPort("127.0.0.1", 8080));
        assertThat(result4).isEqualTo("127.0.0.1:8080");
    }

}
