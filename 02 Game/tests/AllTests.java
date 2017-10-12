import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = {MapTest.class,
        AttributesTest.class,
        GameCharacterAttributesTest.class,
        ArmourAttributesTest.class,
        WeaponAttributesTest.class,
        EquipmentTest.class,
        GameCharacterTest.class,
        BagTest.class})
public class AllTests {


}
