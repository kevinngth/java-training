package com.foobarqix.foobarqix;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FooBarQixTest {
    @Test
    void shouldBeTrue() {
        assertThat(true).isEqualTo(true);
    }

    @Test
    void shouldReturn1() {
        FooBarQix fooBarQix = new FooBarQix();
        assertThat(fooBarQix.print(1)).isEqualTo("1");
    }

    @Test
    void shouldReturnFoo() {
        FooBarQix fooBarQix = new FooBarQix();
        assertThat(fooBarQix.print(6)).isEqualTo("Foo");
    }

    @Test
    void shouldReturnBar() {
        FooBarQix fooBarQix = new FooBarQix();
        assertThat(fooBarQix.print(10)).isEqualTo("Bar");
    }

    @Test
    void shouldReturnQix() {
        FooBarQix fooBarQix = new FooBarQix();
        assertThat(fooBarQix.print(14)).isEqualTo("Qix");
    }

    @Test
    void shouldReturnFooFoo() {
        FooBarQix fooBarQix = new FooBarQix();
        assertThat(fooBarQix.print(3)).isEqualTo("FooFoo");
    }

    @Test
    void shouldLookAtDivisorsBeforeContent() {
        FooBarQix fooBarQix = new FooBarQix();
        assertThat(fooBarQix.print(51)).isEqualTo("FooBar");
    }

    @Test
    void shouldLookAtContentInOrderOfAppearance() {
        FooBarQix fooBarQix = new FooBarQix();
        assertThat(fooBarQix.print(53)).isEqualTo("BarFoo");
    }

    @Test
    void shouldLookAtMultiplesInOrder() {
        FooBarQix fooBarQix = new FooBarQix();
        assertThat(fooBarQix.print(21)).isEqualTo("FooQix");
    }

    @Test
    void shouldReturnFooBarBar() {
        FooBarQix fooBarQix = new FooBarQix();
        assertThat(fooBarQix.print(15)).isEqualTo("FooBarBar");
    }

    @Test
    void shouldReturnFooFooFoo() {
        FooBarQix fooBarQix = new FooBarQix();
        assertThat(fooBarQix.print(33)).isEqualTo("FooFooFoo");
    }
}