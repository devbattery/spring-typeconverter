package hello.typeconverter.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @DisplayName("포맷터로 문자를 숫자로 변환할 수 있다.")
    @Test
    void parse() throws ParseException {
        // given
        Number result = formatter.parse("1,000", Locale.KOREA);

        // when
        // then
        assertThat(result).isEqualTo(1000L); // Long 타입 주의
    }

    @DisplayName("포맷터로 숫자를 문자로 변환할 수 있다.")
    @Test
    void print() {
        // given
        String result = formatter.print(1000, Locale.KOREA);

        // when
        // then
        assertThat(result).isEqualTo("1,000");
    }

}
