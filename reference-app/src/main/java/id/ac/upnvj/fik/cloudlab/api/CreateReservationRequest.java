package id.ac.upnvj.fik.cloudlab.api;

import java.time.Instant;

public record CreateReservationRequest(
    Long laboratoryId,
    Instant startTime,
    Instant endTime,
    String purpose
) {}
