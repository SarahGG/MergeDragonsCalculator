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
        specifiedGen = 1;
        royalPop = 3;
        currentPopByGen = new int[]{0};
    }

    @Test
    public void specifiedGenOf2ReturnsGenLength2() {
        targetPopByGen = calculator.getTargetPopByGen(specifiedGen, royalPop, currentPopByGen);

        Assert.assertEquals(targetPopByGen.length, specifiedGen);
    }

    @Test
    public void royalPopOf3ReturnsGen0PopOf3() {
        targetPopByGen = calculator.getTargetPopByGen(specifiedGen, royalPop, currentPopByGen);

        Assert.assertEquals(targetPopByGen[0], 3);
    }

    @Test
    public void royalPopOf3And1OwnedReturnsGen0PopOf2() {
        currentPopByGen = new int[]{1};

        targetPopByGen = calculator.getTargetPopByGen(specifiedGen,royalPop, currentPopByGen);

        Assert.assertEquals(targetPopByGen[0], 2);
    }

    @Test
    public void royalPopOf3ReturnsGen1PopOf10() {
        specifiedGen = 2;

        targetPopByGen = calculator.getTargetPopByGen(specifiedGen,royalPop,currentPopByGen);

        Assert.assertEquals(targetPopByGen[1], 10);

    }
}
