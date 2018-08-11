package net.lestephane.pos.test;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PointOfSaleTests {
    private static class PointOfSale {
        private final Display price;

        public PointOfSale(final Display display) {
            this.price = display;
        }

        public void onBarcode(String s) {
            if (null == s) {
                priceScannedIsInvalid();
            }
        }

        private void priceScannedIsInvalid() {
            price.displayText("invalid barcode");
        }

    }

    private interface Display {
        void displayText(String text);
    }

    private final DisplaySpy display;
    private final PointOfSale pos;

    public PointOfSaleTests() {
        this.display = new DisplaySpy();
        this.pos = new PointOfSale(this.display);
    }

    private static class DisplaySpy implements Display {
        private String lastDisplayedText = null;
        @Override
        public void displayText(String text) {
            this.lastDisplayedText = text;
        }
    }

    @Test
    public void rejectsNullBarcode() {
        givenBarcodeText(null);
        priceDisplayedShouldBe("invalid barcode");
    }

    private void givenBarcodeText(String s) {
        pos.onBarcode(s);
    }

    private void priceDisplayedShouldBe(String displayText) {
        assertThat(display.lastDisplayedText, is(displayText));
    }
}
