package hello.typeconverter.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

class FormattingConversionServiceTest {

    @DisplayName("포맷터 컨버전 서비스를 이용할 수 있다.")
    @Test
    void formatting_conversion_service() {
        // given
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        // 컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // 포맷터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        // when
        // 컨버터 사용
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);

        // 포맷터 사용
        String result1 = conversionService.convert(1000, String.class);
        Long result2 = conversionService.convert("1,000", Long.class);

        // then
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
        assertThat(result1).isEqualTo("1,000");
        assertThat(result2).isEqualTo(1000);
    }

}
