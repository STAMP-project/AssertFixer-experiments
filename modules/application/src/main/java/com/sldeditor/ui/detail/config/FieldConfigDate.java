/*
 * SLD Editor - The Open Source Java SLD Editor
 *
 * Copyright (C) 2016, SCISYS UK Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.sldeditor.ui.detail.config;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateTimeChangeListener;
import com.github.lgooddatepicker.optionalusertools.PickerUtilities;
import com.github.lgooddatepicker.zinternaltools.DateTimeChangeEvent;
import com.sldeditor.common.console.ConsoleManager;
import com.sldeditor.common.undo.UndoActionInterface;
import com.sldeditor.common.undo.UndoEvent;
import com.sldeditor.common.undo.UndoInterface;
import com.sldeditor.common.undo.UndoManager;
import com.sldeditor.common.xml.ui.FieldIdEnum;
import com.sldeditor.filter.v2.function.temporal.DateUtils;
import com.sldeditor.ui.detail.BasePanel;
import com.sldeditor.ui.widgets.FieldPanel;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import org.opengis.filter.expression.Expression;

/**
 * The Class FieldConfigDate wraps a date picker GUI component.
 *
 * <p>Supports undo/redo functionality.
 *
 * <p>Instantiated by {@link com.sldeditor.ui.detail.config.ReadPanelConfig}
 *
 * @author Robert Ward (SCISYS)
 */
public class FieldConfigDate extends FieldConfigBase implements UndoActionInterface {

    /** The old value obj. */
    private Object oldValueObj = null;

    /** The date/time picker. */
    private DateTimePicker dateTimePicker;

    /** The date model. */
    private DatePickerSettings dateModel = new DatePickerSettings();

    /** The time model. */
    private TimePickerSettings timeModel = new TimePickerSettings();

    /**
     * Flag indicating whether class is being populated, prevents multiple undo events being
     * triggered when setting a date value.
     */
    private boolean isPopulating = false;

    /** The zone id. */
    private ZoneId zoneId = ZoneId.of("Z");

    /**
     * Instantiates a new field config date.
     *
     * @param commonData the common data
     */
    public FieldConfigDate(FieldConfigCommonData commonData) {
        super(commonData);
    }

    /** Creates the ui. */
    /*
     * (non-Javadoc)
     *
     * @see com.sldeditor.ui.detail.config.FieldConfigBase#createUI()
     */
    @Override
    public void createUI() {
        if (dateTimePicker == null) {
            int xPos = getXPos();

            FieldPanel fieldPanel = createFieldPanel(xPos, getLabel());

            dateModel = new DatePickerSettings();
            timeModel = new TimePickerSettings();
            dateModel.setAllowEmptyDates(false);
            timeModel.setAllowEmptyTimes(false);
            timeModel.setDisplaySpinnerButtons(true);
            timeModel.setDisplayToggleTimeMenuButton(false);
            timeModel.setFormatForDisplayTime(
                    PickerUtilities.createFormatterFromPatternString(
                            "HH:mm:ss", timeModel.getLocale()));

            dateTimePicker = new DateTimePicker(dateModel, timeModel);

            dateTimePicker.setBounds(
                    xPos + BasePanel.WIDGET_X_START,
                    0,
                    BasePanel.WIDGET_STANDARD_WIDTH * 2,
                    BasePanel.WIDGET_HEIGHT);
            fieldPanel.add(dateTimePicker);

            dateTimePicker.addDateTimeChangeListener(
                    new DateTimeChangeListener() {
                        @Override
                        public void dateOrTimeChanged(DateTimeChangeEvent event) {
                            valueStored();
                        }
                    });

            if (!isValueOnly()) {
                setAttributeSelectionPanel(
                        fieldPanel.internalCreateAttrButton(Double.class, this, isRasterSymbol()));
            }
        }
    }

    /** Value stored. */
    protected void valueStored() {
        if (!isSuppressUndoEvents() && !isPopulating) {
            ZonedDateTime newValueObj = getDate();

            UndoManager.getInstance()
                    .addUndoEvent(new UndoEvent(this, getFieldId(), oldValueObj, newValueObj));

            oldValueObj = newValueObj;
        }
        valueUpdated();
    }

    /**
     * Attribute selection.
     *
     * @param field the field
     */
    /*
     * (non-Javadoc)
     *
     * @see
     * com.sldeditor.ui.iface.AttributeButtonSelectionInterface#attributeSelection(java.lang.String)
     */
    @Override
    public void attributeSelection(String field) {
        // Not used
    }

    /**
     * Sets the enabled.
     *
     * @param enabled the new enabled
     */
    /*
     * (non-Javadoc)
     *
     * @see com.sldeditor.ui.detail.config.FieldConfigBase#setEnabled(boolean)
     */
    @Override
    public void internal_setEnabled(boolean enabled) {
        if (dateTimePicker != null) {
            dateTimePicker.setEnabled(enabled);
        }
    }

    /**
     * Generate expression.
     *
     * @return the expression
     */
    /*
     * (non-Javadoc)
     *
     * @see com.sldeditor.ui.detail.config.FieldConfigBase#generateExpression()
     */
    @Override
    protected Expression generateExpression() {
        Expression expression = null;

        if (dateTimePicker != null) {
            expression = getFilterFactory().literal(getStringValue());
        }
        return expression;
    }

    /**
     * Checks if is enabled.
     *
     * @return true, if is enabled
     */
    /*
     * (non-Javadoc)
     *
     * @see com.sldeditor.ui.detail.config.FieldConfigBase#isEnabled()
     */
    @Override
    public boolean isEnabled() {
        if ((attributeSelectionPanel != null) && !isValueOnly()) {
            return attributeSelectionPanel.isEnabled();
        } else {
            if (dateTimePicker != null) {
                return dateTimePicker.isEnabled();
            }
        }
        return false;
    }

    /** Revert to default value. */
    /*
     * (non-Javadoc)
     *
     * @see com.sldeditor.ui.detail.config.FieldConfigBase#revertToDefaultValue()
     */
    @Override
    public void revertToDefaultValue() {
        ZonedDateTime currentDate = ZonedDateTime.now();

        populateField(currentDate);
    }

    /**
     * Populate expression.
     *
     * @param objValue the obj value
     */
    /*
     * (non-Javadoc)
     *
     * @see com.sldeditor.ui.detail.config.FieldConfigBase#populateExpression(java.lang.Object)
     */
    @Override
    public void populateExpression(Object objValue) {
        ZonedDateTime value = null;

        if (objValue instanceof ZonedDateTime) {
            value = (ZonedDateTime) objValue;
        } else if (objValue instanceof String) {
            try {
                value = DateUtils.getZonedDateTime((String) objValue);
            } catch (DateTimeParseException e) {
                ConsoleManager.getInstance().exception(this, e);
            }
        }

        populateField(value);
    }

    /**
     * Gets the string value.
     *
     * @return the string value
     */
    @Override
    public String getStringValue() {
        ZonedDateTime date = getDate();
        if (date == null) {
            return null;
        }

        return DateUtils.getString(date);
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    private ZonedDateTime getDate() {
        if (dateTimePicker == null) {
            return null;
        }
        LocalDateTime localDateTime = dateTimePicker.getDateTimeStrict();

        if (localDateTime == null) {
            return null;
        }

        ZonedDateTime newDateTime = localDateTime.atZone(zoneId);

        return newDateTime;
    }

    /**
     * Undo action.
     *
     * @param undoRedoObject the undo/redo object
     */
    @Override
    public void undoAction(UndoInterface undoRedoObject) {
        if ((dateModel != null) && (undoRedoObject != null)) {
            if (undoRedoObject.getOldValue() instanceof ZonedDateTime) {
                ZonedDateTime oldValue = (ZonedDateTime) undoRedoObject.getOldValue();

                populateUI(oldValue);
                dateTimePicker.setDateTimeStrict(oldValue.toLocalDateTime());
            }
        }
    }

    /**
     * Populate UI.
     *
     * @param value the value
     */
    private void populateUI(ZonedDateTime value) {
        zoneId = value.getZone();

        dateTimePicker.setDateTimeStrict(value.toLocalDateTime());
    }

    /**
     * Redo action.
     *
     * @param undoRedoObject the undo/redo object
     */
    @Override
    public void redoAction(UndoInterface undoRedoObject) {
        if ((dateModel != null) && (undoRedoObject != null)) {
            if (undoRedoObject.getNewValue() instanceof ZonedDateTime) {
                ZonedDateTime newValue = (ZonedDateTime) undoRedoObject.getNewValue();

                populateUI(newValue);
            }
        }
    }

    /**
     * Sets the test value.
     *
     * @param fieldId the field id
     * @param testValue the test value
     */
    @Override
    public void setTestValue(FieldIdEnum fieldId, String testValue) {
        ZonedDateTime date = DateUtils.getZonedDateTime(testValue);

        populateField(date);
    }

    /**
     * Populate field.
     *
     * @param value the value
     */
    @Override
    public void populateField(ZonedDateTime value) {
        if ((dateTimePicker != null) && (value != null)) {
            isPopulating = true;

            populateUI(value);

            if (!isSuppressUndoEvents()) {
                UndoManager.getInstance()
                        .addUndoEvent(new UndoEvent(this, getFieldId(), oldValueObj, value));
                oldValueObj = value;
            }

            isPopulating = false;
        }
    }

    /**
     * Creates a copy of the field.
     *
     * @param fieldConfigBase the field config base
     * @return the field config base
     */
    @Override
    protected FieldConfigBase createCopy(FieldConfigBase fieldConfigBase) {
        FieldConfigDate copy = null;
        if (fieldConfigBase != null) {
            copy = new FieldConfigDate(getCommonData());
            copy.zoneId = zoneId;
        }
        return copy;
    }

    /**
     * Sets the field visible.
     *
     * @param visible the new visible state
     */
    @Override
    public void setVisible(boolean visible) {
        if (dateTimePicker != null) {
            dateTimePicker.setVisible(visible);
        }
    }
}
