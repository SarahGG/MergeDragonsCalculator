import org.junit.Assert;
import org.junit.Test;

public class MergeCalculatorTest {
    private MergeCalculator calculator;
    private int specifiedGen;
    private int royalPop;
    private int[] targetPopByGen;

    public MergeCalculatorTest() {
        calculator = new MergeCalculator();
    }

    @Test
    public void specifiedGenOf2ReturnsGenLength2() {
        specifiedGen = 1;
        royalPop = 3;

        targetPopByGen = calculator.getTargetPopByGen(specifiedGen, royalPop);

        Assert.assertEquals(targetPopByGen.length, specifiedGen);
    }

    @Test
    public void royalPopOf3ReturnsGen0PopOf3() {
        specifiedGen = 1;
        royalPop = 3;

        targetPopByGen = calculator.getTargetPopByGen(specifiedGen, royalPop);

        Assert.assertEquals(targetPopByGen[0], 3);
    }

}
