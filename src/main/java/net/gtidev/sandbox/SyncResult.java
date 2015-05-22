package net.gtidev.sandbox;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SyncResult<T> {
    private T id;
    private SyncStatus status;
}
