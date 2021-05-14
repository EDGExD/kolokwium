package edu.iis.mto.oven;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
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
    void test_1_Oven_Exception() throws HeatingException {
        //HeatingSettings heatingSettings = HeatingSettings.builder().withTargetTemp(200).withTimeInMinutes(20).build();
        Mockito.doThrow(new HeatingException()).when(heatingModule).termalCircuit(any());
        
        List<ProgramStage> stagesList = new ArrayList<ProgramStage>();
        stagesList.add(ProgramStage.builder().withHeat(HeatType.THERMO_CIRCULATION).withTargetTemp(200).withStageTime(20).build());
        BakingProgram program = BakingProgram.builder().withInitialTemp(180).withStages(stagesList).build();
        
        Oven piekarnik = new Oven(heatingModule, fan);
        try{
            piekarnik.start(program);
        }
        catch(OvenException e){
            MatcherAssert.assertThat(true, equalTo(true));
        }
        MatcherAssert.assertThat(false, equalTo(true));
    }

}
