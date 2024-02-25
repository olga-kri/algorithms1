import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringListImplTest {
    private final StringListImpl out = new StringListImpl();

   @BeforeEach
   public void AddItem(){
       out.add(0,"ЮАР");
       out.add(1,"Мальдивы");
       out.add(2,"Индонезия");
       out.add(3,"Франция");
       out.add(4,"Доминикана");
       out.add(5,"Китай");
   }
   @AfterEach
   public void removeStorage(){
       out.clear();
   }
    @Test
    public void ShouldThrowExceptionWhenItemIsNull() {
        Assertions.assertThrows(CanNotAddNullException.class, () -> out.add(null));
    }
    @Test
    public void ShouldThrowExceptionDontFindElement() {
        Assertions.assertThrows(DontFindElementException.class, () -> out.remove("Россия"));
    }
    @Test
    public void StorageIsEmpty(){
       out.clear();
       Assertions.assertTrue(out.isEmpty());
    }
    @Test
    public void SetAndGetItem(){
        out.set(5,"Грузия");
        Assertions.assertEquals("Грузия",out.get(5));
    }
    @Test
    public void AddAndContainItem(){
        Assertions.assertTrue(out.contains("Мальдивы"));
    }
    @Test
    public void AddWithoutIndexAndContainItem(){
        out.clear();
        out.add("ЮАР");
        out.add("Мальдивы");
        out.add("Индонезия");
        out.add("Франция");
        out.add("Доминикана");
        out.add("Китай");
       Assertions.assertTrue(out.contains("Мальдивы"));
    }
    @Test
    public void AddAndGetItem(){
        Assertions.assertEquals("Китай",out.get(5));
    }
    @Test
    public void AddAndRemoveItem(){
        out.remove("ЮАР");
        Assertions.assertEquals("Мальдивы",out.get(0));
    }
    @Test
    public void AddAndRemoveIndex(){
        out.remove(3);
        Assertions.assertEquals("Доминикана",out.get(3));
    }
    @Test
    public void AddAndFindIndexOfDontExistItem(){
        Assertions.assertEquals(-1,out.indexOf("Ямайка"));
    }
    @Test
    public void AddAndFindLastIndexOfDontExistItem(){
        Assertions.assertEquals(-1,out.lastIndexOf("Турция"));
    }
    @Test
    public void ClearSize(){
     out.clear();
     Assertions.assertTrue(out.size()==0);
    }
    @Test
    public void SetAndFindIndexOfItem(){
        Assertions.assertEquals(1,out.indexOf("Мальдивы"));
    }
    @Test
    public void SetAndFindLastIndexOfItem(){
        Assertions.assertEquals(1,out.lastIndexOf("Мальдивы"));
    }
    @Test
    public void ReturnArray(){
        String[] controlArray = {"ЮАР","Мальдивы","Индонезия","Франция","Доминикана","Китай"};
        Assertions.assertTrue(Arrays.equals(controlArray,out.toArray()));
    }
    @Test
    public void EquelsToOtherList(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("Аргентина");
        stringList.add("Чехословакия");
        stringList.add("Польша");
        Assertions.assertFalse(out.equals(stringList));
    }
    @Test
    public void ShouldThrowExceptionIllegalArgument() {
        Assertions.assertThrows(IllegalIndexException.class,()->out.remove(7));
    }
    @Test
    public void SholdBeExceptionWhenStorageIsFull(){
         Assertions.assertThrows(MemoryIsFullException.class,()->out.add("Северная Корея"));
    }
}


