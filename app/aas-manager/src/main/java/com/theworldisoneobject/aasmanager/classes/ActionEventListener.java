package com.theworldisoneobject.aasmanager.classes;

import java.awt.event.ActionEvent;

/**
 * Interface for ActionEventListeners
 */

public interface ActionEventListener {
    /**
     * Method to be called when an ActionEvent is received
     * @param event
     */
    void remoteActionPerformed(ActionEvent event);
}
