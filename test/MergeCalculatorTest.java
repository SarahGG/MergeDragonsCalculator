import org.junit.Assert;
import org.junit.Test;

public class MergeCalculatorTest {
    private MergeCalculator calculator;
    private int specifiedGen;
    private int royalPop;
    private int[] targetPopByGen;
    private int[] currentPopByGen;

    public MergeCalculatorTest() {
        calculator = new MergeCalculator();
    }

    @Test
    public void specifiedGenOf2ReturnsGenLength2() {
        specifiedGen = 1;
        royalPop = 3;
        currentPopByGen = new int[]{0};

        targetPopByGen = calculator.getTargetPopByGen(specifiedGen, royalPop, currentPopByGen);

        Assert.assertEquals(targetPopByGen.length, specifiedGen);
    }

    @Test
    public void royalPopOf3ReturnsGen0PopOf3() {
        specifiedGen = 1;
        royalPop = 3;
        currentPopByGen = new int[]{0};

        targetPopByGen = calculator.getTargetPopByGen(specifiedGen, royalPop, currentPopByGen);

        Assert.assertEquals(targetPopByGen[0], 3);
    }

    @Test
    public void royalPopOf3And1OwnedReturnsGen0PopOf2() {
        specifiedGen = 1;
        royalPop = 3;
        currentPopByGen = new int[]{1};

        targetPopByGen = calculator.getTargetPopByGen(specifiedGen, royalPop, currentPopByGen);

        Assert.assertEquals(targetPopByGen[0], 2);
    }
}
