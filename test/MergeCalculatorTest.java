import org.junit.Assert;
import org.junit.Test;

public class MergeCalculatorTest {
    private MergeCalculator calculator;

    public MergeCalculatorTest() {
        calculator = new MergeCalculator();
    }

    @Test
    public void FinalPopulationOf2ReturnsGen0PopulationOf2() {
        int specifiedGen = 2;
        int[] targetPopByGen = calculator.getTargetPopByGen(specifiedGen);

        Assert.assertEquals(targetPopByGen.length, 2);
    }

}
