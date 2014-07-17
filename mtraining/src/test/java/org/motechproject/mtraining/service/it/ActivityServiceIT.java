package org.motechproject.mtraining.service.it;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.mtraining.domain.ActivityRecord;
import org.motechproject.mtraining.domain.ActivityState;
import org.motechproject.mtraining.service.ActivityService;
import org.motechproject.testing.osgi.BasePaxIT;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerSuite;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;


/**
 * Verify that Activity service is present and functional
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class ActivityServiceIT extends BasePaxIT {

    @Inject
    private ActivityService activityService;

    @Test
    public void testActivityServiceInstance() throws Exception {

        assertNotNull(activityService);
    }

    @Test
    public void testActivityCreation() throws Exception {
        ActivityRecord ar = activityService.addActivity(new ActivityRecord("12345", "MyCourse", "MyChapter", "MyLesson",
                DateTime.now(), null, ActivityState.STARTED));

        assertNotNull(ar);
    }
}
