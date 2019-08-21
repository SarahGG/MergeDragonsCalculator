import org.junit.Assert;
import org.junit.Test;

public class MergeCalculatorTest {
    private MergeCalculator calculator;
    private int[] targetPopByGen;

    public MergeCalculatorTest() {
        calculator = new MergeCalculator();
    }

    @Test
    public void specifiedGenOf2ReturnsGenLength2() {
        targetPopByGen = calculator.getTargetPopByGen(2, 3, new int[]{0});

        Assert.assertEquals(targetPopByGen.length, 2);
    }

    @Test
    public void royalPopOf3ReturnsGen0PopOf3() {
        targetPopByGen = calculator.getTargetPopByGen(1, 3, new int[]{0});

        Assert.assertEquals(targetPopByGen[0], 3);
    }

    @Test
    public void royalPopOf3And1OwnedReturnsGen0PopOf2() {
        targetPopByGen = calculator.getTargetPopByGen(1,3, new int[]{1});

        Assert.assertEquals(targetPopByGen[0], 2);
    }

    @Test
    public void royalPopOf3ReturnsGen1PopOf10() {
        targetPopByGen = calculator.getTargetPopByGen(2,3, new int[]{0});

        Assert.assertEquals(targetPopByGen[1], 10);
    }


}
