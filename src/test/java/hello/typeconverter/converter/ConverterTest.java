package hello.typeconverter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @DisplayName("String 타입을 Integer 타입으로 변환할 수 있다.")
    @Test
    void string_to_integer() {
        // given
        StringToIntegerConverter converter = new StringToIntegerConverter();

        // when
        Integer result = converter.convert("10");

        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("Integer 타입을 String 타입으로 변환할 수 있다.")
    @Test
    void integer_to_string() {
        // given
        IntegerToStringConverter converter = new IntegerToStringConverter();

        // when
        String result = converter.convert(10);

        // then
        assertThat(result).isEqualTo("10");
    }

    @DisplayName("ip 주소를 IpPort 객체로 변환할 수 있다.")
    @Test
    void string_to_ip_port() {
        // given
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);

        // when
        String result = converter.convert(source);

        // then
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @DisplayName("IpPort 객체를 ip 주소로 변환할 수 있다.")
    @Test
    void ip_port_to_string() {
        // given
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";

        // when
        IpPort result = converter.convert(source);

        // then
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080)); // @EqualsAndHashCode
    }

}
