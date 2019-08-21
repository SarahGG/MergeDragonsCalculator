import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeCalculatorTest {
    private MergeCalculator calculator;
    private int[] targetPopByGen;

    public MergeCalculatorTest() {
        calculator = new MergeCalculator();
    }

    @Test
    public void specifiedGenOf2ReturnsGenLength2() {
        targetPopByGen = calculator.getTargetPopByGen(2, 3);
        Assert.assertEquals(targetPopByGen.length, 2);
    }

    @Test
    public void specifiedGenOf4ReturnsGenLength4() {
        targetPopByGen = calculator.getTargetPopByGen(4,3);
        Assert.assertEquals(targetPopByGen.length, 4);
    }

    @Test
    public void royalPopOf3ReturnsGen0PopOf3() {
        targetPopByGen = calculator.getTargetPopByGen(1, 3);
        Assert.assertEquals(targetPopByGen[0], 3);
    }

    @Test
    public void royalPopOf3And1OwnedReturnsGen0PopOf2() {
        targetPopByGen = calculator.getTargetPopByGen(1,3, new int[]{1});
        Assert.assertEquals(targetPopByGen[0], 2);
    }

    @Test
    public void royalPopOf3ReturnsGen1PopOf10() {
        targetPopByGen = calculator.getTargetPopByGen(2,3);
        Assert.assertEquals(targetPopByGen[1], 10);
    }

    @Test
    public void royalPopOf3ReturnsGen2PopOf34() {
        targetPopByGen = calculator.getTargetPopByGen(3,3);
        Assert.assertEquals(targetPopByGen[2],34);
    }

    @Test
    public void royalPopOf3AndCurrentGen3PopOf2ReturnsGen3PopOf112 () {
        targetPopByGen = calculator.getTargetPopByGen(4,3,new int[]{0,0,0,2});
        Assert.assertEquals(targetPopByGen[3], 112);
    }

    @Test
    public void royalPopOf3AndMixedCurrentGensReturnsGen6PopOf1228() {
        targetPopByGen = calculator.getTargetPopByGen(6,3,new int[]{0,0,0,2,0,20});
    }

    @Test
    public void royalPopOf3ReturnsGen3PopOf10() {
        calculator = new MergeCalculator(7,9,3,5);
        targetPopByGen = calculator.getTargetPopByGen(4,3, new int[]{0,0,0,4});
        System.out.println(Arrays.toString(targetPopByGen));
        Assert.assertEquals(targetPopByGen[3],10);
    }
}
