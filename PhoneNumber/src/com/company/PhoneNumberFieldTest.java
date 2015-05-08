package com.company;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by pgicking on 5/8/15.
 */
public class PhoneNumberFieldTest {

    private int[] basic11Phone = {1,2,3,4,5,6,7,8,9,0,1};
    private int[] basic10Phone = {5,0,3,5,1,6,0,4,2,5};
    private int[] basic7Phone = {1,2,3,4,5,6,7};
    private int[] emptyPhone = {};
    private int[] basicExt = {1};
    private int[] noExt = {};


    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @BeforeClass
    public static void ready() {
        System.out.println("BEGIN PHONE NUMBER FIELD TESTS");
    }

    @AfterClass
    public static void done() {
        System.out.println("END PHONE NUMBER FIELD TESTS");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("    Test start");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("    Test complete");
    }

    @Test
    public void sevenDigitPhoneNumberWithoutExtension() throws Exception  {
        String result = PhoneNumberField.formatPhoneNumber(basic7Phone,noExt);
        assertEquals("7 Digit No Extension", result, "123-4567");
    }

    @Test
    public void sevenDigitPhoneNumberWithExtension() throws Exception  {
        String result = PhoneNumberField.formatPhoneNumber(basic7Phone,basicExt);
        assertEquals("7 Digit With Extension",result,"123-4567 ext. 1");
    }

    @Test
    public void tenDigitPhoneNumberWithoutExtension() throws Exception {
        String result = PhoneNumberField.formatPhoneNumber(basic10Phone,noExt);
        assertEquals("10 Digit No Extension", result, "(503) 516-0425");
    }

    @Test
    public void elevenDigitPhoneNumberWithoutExtension() throws Exception {
        String result = PhoneNumberField.formatPhoneNumber(basic11Phone,noExt);
        assertEquals("11 Digit No Extension",result,"+1 (234) 567-8901");

    }

    @Test
    public void elevenDigitPhoneNumberWithExtension() throws Exception {
        String result = PhoneNumberField.formatPhoneNumber(basic11Phone,basicExt);
        assertEquals("11 Digit With Extension",result,"+1 (234) 567-8901 ext. 1");

    }

    @Test
    public void emptyPhoneNumberLengthWithExtension() throws Exception {
        String result = PhoneNumberField.formatPhoneNumber(emptyPhone,basicExt);
        assertEquals("Empty Phone number Extension",result," ext. 1");
    }

    @Test
    public void emptyPhoneNumberLengthWithNoExtension() throws Exception {
        String result = PhoneNumberField.formatPhoneNumber(emptyPhone,noExt);
        assertEquals("Empty Phone number No Extension",result,"");
    }

    @Test
    public void invalidPhoneLengthWithExtension() throws Exception {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Parsed phone number is invalid length.");
        int[] badPhone = {1,2,3,4};
        PhoneNumberField.formatPhoneNumber(badPhone, basicExt);
    }

    @Test
    public void invalidPhoneLengthShortWithNoExtension() throws Exception {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Parsed phone number is invalid length.");
        int[] badPhone = {1,2,3,4};
        PhoneNumberField.formatPhoneNumber(badPhone, noExt);
    }

    @Test
    public void invalidPhoneLengthLongWithNoExtension() throws Exception {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Parsed phone number is invalid length.");
        int[] badPhone = {1,2,3,4,5,6,7,8,9,9,9,9,9,9,9};
        PhoneNumberField.formatPhoneNumber(badPhone, noExt);
    }

    @Test
    public void invalidPhoneLengthShortWithExtension() throws Exception {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Parsed phone number is invalid length.");
        int[] badPhone = {1,2,3,4};
        PhoneNumberField.formatPhoneNumber(badPhone, basicExt);
    }

    @Test
    public void invalidPhoneLengthLongWithExtension() throws Exception {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Parsed phone number is invalid length.");
        int[] badPhone = {1,2,3,4,5,6,7,8,9,9,9,9,9,9,9};
        PhoneNumberField.formatPhoneNumber(badPhone,basicExt);
    }

    @Test
    public void validPhoneWithNullExtension() throws Exception {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("null");
        int[] badExt = {Integer.parseInt(null)};
        PhoneNumberField.formatPhoneNumber(basic10Phone,badExt);
    }

    @Test
    public void invalidPhoneWithNoExtension() throws Exception {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("null");
        int[] badPhone = {Integer.parseInt(null)};
        PhoneNumberField.formatPhoneNumber(badPhone,noExt);
    }

    @Test
    public void PhoneWithNullCharsNoExtension() throws Exception {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("null");
        int[] badPhone = {1,2,3,4,5,6,Integer.parseInt(null)};
        PhoneNumberField.formatPhoneNumber(badPhone,noExt);
    }

    @Test
    public void PhoneWithAllNullCharsNoExtension() throws Exception {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("null");
        int[] badPhone = {Integer.parseInt(null),Integer.parseInt(null),Integer.parseInt(null),Integer.parseInt(null),Integer.parseInt(null),Integer.parseInt(null),Integer.parseInt(null)};
        PhoneNumberField.formatPhoneNumber(badPhone,noExt);
    }

    @Test
    @Ignore("Behavior probably not intended")
    public void PhoneWithINT_MAXNoExtension() throws Exception {
        int[] badPhone = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
        String result = PhoneNumberField.formatPhoneNumber(badPhone,noExt);
        System.out.println(result);
    }

    @Test
    @Ignore("Behavior probably not intended")
    public void invalidCharactersWithValidExt() throws Exception {
        int[] badphone = {-1,-2,-3,-4,-5,-6,-7};
        String result = PhoneNumberField.formatPhoneNumber(badphone,basicExt);
    }

    @Test
    @Ignore("Behavior probably not intended")
    public void validPhoneWithLongExtension() throws Exception {
        int[] longExt = {Integer.MAX_VALUE};
        String result = PhoneNumberField.formatPhoneNumber(basic10Phone,longExt);
        assertEquals("10 Digit Number Long Extension",result,"(503) 516-0425 ext. 2147483647");
    }

    @Test
    public void testGetPhoneNumber() throws Exception {
    }

    @Test
    public void testFormatPhoneNumber() throws Exception {

    }

    @Test
    public void testParseContentsForPhoneNumber() throws Exception {

    }
}