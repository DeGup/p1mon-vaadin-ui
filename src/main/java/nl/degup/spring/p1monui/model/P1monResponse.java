package nl.degup.spring.p1monui.model;

import lombok.Data;

import java.util.Date;

@Data
public class P1monResponse {
    private final Date timestamp;
    private final String utcTimestamp;


}
