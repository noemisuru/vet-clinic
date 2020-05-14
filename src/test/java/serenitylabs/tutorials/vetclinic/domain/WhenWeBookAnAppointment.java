package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WhenWeBookAnAppointment {

    private static final LocalDateTime TODAY_AT_2_PM = LocalDateTime.now().withHour(2).withMinute(0);
    private static final LocalDateTime TODAY_AT_3_PM = LocalDateTime.now().withHour(3).withMinute(0);
    private static final LocalDateTime TOMORROW_AT_1_PM = LocalDateTime.now().plusDays(1).withHour(1).withMinute(0);
    private static final LocalDateTime TODAY_AT_1_PM = LocalDateTime.now().withHour(1).withMinute(0);
    private static final LocalDateTime YESTERDAY_AT_3_PM = LocalDateTime.now().minusDays(1).withHour(3).withMinute(0);

    @Test
    public void an_appointment_has_a_patient_name_an_owner_and_a_date() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").at(TODAY_AT_2_PM);

        assertThat("Fido",is(equalTo(appointment.getPetName())));
        assertThat("Fred",is(equalTo(appointment.getOwner())));
        assertThat(TODAY_AT_2_PM,is(equalTo(appointment.getAppointmentTime())));
    }


    @Test
    public void an_appointment_can_have_an_optional_reason() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He is sick").at(TODAY_AT_2_PM);

        assertThat(appointment.getReason().isPresent(),is(true));
        assertThat("He is sick",is(equalTo(appointment.getReason().get())));
    }

    @Test
    public void an_appointment_has_correct_isBefore_check() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He is sick").at(TODAY_AT_2_PM);

        assertThat(appointment.isBefore(TODAY_AT_3_PM), is(true));
        assertThat(appointment.isBefore(TOMORROW_AT_1_PM), is(true));
        assertThat(appointment.isBefore(YESTERDAY_AT_3_PM), is(false));
        assertThat(appointment.isBefore(TODAY_AT_1_PM), is(false));
    }

    @Test
    public void an_appointment_has_correct_isAfter_check() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He is sick").at(TODAY_AT_2_PM);

        assertThat(appointment.isAfter(TODAY_AT_3_PM), is(false));
        assertThat(appointment.isAfter(TOMORROW_AT_1_PM), is(false));
        assertThat(appointment.isAfter(YESTERDAY_AT_3_PM), is(true));
        assertThat(appointment.isAfter(TODAY_AT_1_PM), is(true));
    }

}
