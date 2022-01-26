package TirePressureMonitoringSystem_6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    private Sensor sensorMock;
    private Alarm alarm;

    @Before
    public void setUp() {
        sensorMock = Mockito.mock(Sensor.class);
        alarm = new Alarm(sensorMock);
    }

    @Test
    public void testAlarmWhenPsiPressureValueUnderLowPressureThreshold() {
        Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn(15.6);

        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWhenPsiPressureValueOverHighPressureThreshold() {
        Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn(24.8);

        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWhenPsiPressureValueBetweenLowAndHighPressureThreshold() {
        Mockito.when(sensorMock.popNextPressurePsiValue()).thenReturn(18.3);

        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }
}