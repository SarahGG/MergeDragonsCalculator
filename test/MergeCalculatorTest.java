import org.junit.Assert;
import org.junit.Test;

public class MergeCalculatorTest {
    private MergeCalculator calculator;
    private int specifiedGen;
    private int[] targetPopByGen;

    public MergeCalculatorTest() {
        calculator = new MergeCalculator();
    }

    @Test
    public void specifiedGenOf2ReturnsGenLength2() {
        specifiedGen = 1;

        targetPopByGen = calculator.getTargetPopByGen(specifiedGen);

        Assert.assertEquals(targetPopByGen.length, specifiedGen);
    }


}
