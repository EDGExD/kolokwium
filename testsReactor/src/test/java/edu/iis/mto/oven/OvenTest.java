package edu.iis.mto.oven;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OvenTest {

    @Mock
    HeatingModule heatingModule;
    
    @Mock
    Fan fan;
    
    @Test
    void itCompiles() {
        MatcherAssert.assertThat(true, equalTo(true));
    }
    
    @Test
    void test_1() {
        List<ProgramStage> stagesList = new ArrayList<ProgramStage>();
        stagesList.add(ProgramStage.builder().withHeat(HeatType.THERMO_CIRCULATION).withTargetTemp(200).withStageTime(20).build());
        BakingProgram program = BakingProgram.builder().withInitialTemp(180).withStages(stagesList).build();
        Oven piekarnik = new Oven(heatingModule, fan);
        piekarnik.start(program);
        MatcherAssert.assertThat(true, equalTo(true));
    }

}
