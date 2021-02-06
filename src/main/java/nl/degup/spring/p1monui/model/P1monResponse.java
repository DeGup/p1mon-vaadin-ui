package nl.degup.spring.p1monui.model;

import lombok.Data;

import java.util.Date;

@Data
public class P1monResponse {
    private final Date timestamp;
    private final String utcTimestamp;
    private final boolean isProcessed; // 0 / 1 in api
    private final long consumptionKwhLowTotal;
    private final long consumptionKwhHighTotal;
    private final long productionKwhLowTotal;
    private final long productionKwhHighTotal;
    private String tarifCode; // Low = D, High = P
    private final int consumptionWLow;
    private final int consumptionWHigh;
    private final int productionWLow;
    private final int productionWHigh;
    private final long consumptionGarM3;

/*
[
  [
    "2021-02-06 10:13:42",
    1612602822,
    0,
    6570.936,
    5251.012,
    37.539,
    64.36,
    "D",
    121,
    0,
    4128.063
  ]
]
 */

}
