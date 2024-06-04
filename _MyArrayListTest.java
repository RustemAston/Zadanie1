import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class _MyArrayListTest {
    _MyArrayList<String> test3;

    @BeforeEach
    public void setUp(){
        test3 = new _MyArrayList<>();
        test3.add("1");
        test3.add("2");
        test3.add("3");
        test3.add("4");
        test3.add("new");
        test3.add("6");
    }

    @Test
    void quantity_Should_Return_Size_Of_MyArrayList() {
        //Given
        setUp();

        // when
        test3.quantity();

        //then
        assertEquals(6, test3.quantity());
    }

    @Test
    void add_Should_add_New_Object_To_The_End_Of_MyArrayList() {
        //Given
        setUp();

        // when
        test3.add("MyObject");

        //then
        assertTrue("MyObject".equals(test3.get(test3.quantity()-1)));
    }

    @Test
    void add_by_index_Should_add_New_Object_To_The_Specified_Index_Of_MyArrayList() {
        //Given
        setUp();

        // when
        test3.add(0, "MyObject");

        //then
        assertEquals(test3.get(0), "MyObject");
    }

    @Test
    void indexOf_Should_Return_Index_Of_Specified_Object_in_MyArrayList() {
        //Given
        setUp();

        // when
        test3.indexOf("new");

        //then
        assertTrue(test3.indexOf("new") == 4);
    }

    @Test
    void remove_By_Object_Should_Remove_Object_From_MyArrayList() {
        //Given
        setUp();

        // when
        test3.remove("new");

        //then
        assertNotSame(test3.get(4), "new");
    }

    @Test
    void remove_By_Index_Should_Remove_Object_With_Specified_Index_From_MyArrayList() {
        //Given
        setUp();

        // when
        test3.remove(0);

        //then
        assertTrue(test3.get(0).equals("2"));
    }

    @Test
    void get_Should_Return_Object_By_Specified_Index_From_MyArrayList() {
        //Given
        setUp();

        // when
        test3.get(4);

        //then
        assertEquals(test3.get(4), "new");
    }

    @Test
    void set_Should_Put_Object_To_Specified_Index_Of_MyArrayList() {
        //Given
        setUp();

        // when
        test3.set(0, "Mario");

        //then
        assertEquals(test3.get(0), "Mario");
    }

    @Test
    void checkSize_Should_Check_Whether_Index_Is_Bigger_Then_The_Actual_Size_Of_MyArrayList() {
        //Given
        setUp();

        // when
        int ind = 7;
        test3.quantity(); // == 5

        //then
        assertTrue(test3.checkSize(ind));
//        assertThrows(IndexOutOfBoundsException.class, () -> test3.get(ind));
    }

    @Test
    void biggerArray_Should_Make_Bigger_Array_Copying_All_The_Elements_From_The_Previous_One() {
        //Given
        setUp();

        // when
        test3.biggerArray(20);
        int arrFullSizeField = 0;

        try {
            Field field = test3.getClass().getDeclaredField("arrFullSize");
            field.setAccessible(true);
            arrFullSizeField = (Integer) field.get(test3);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //then
        assertEquals(arrFullSizeField, 20);
    }
}