package com.vilyever.unitconversion;

/**
 * VDTimeUnit
 * AndroidUnitConversion <com.vilyever.vdunitconversion>
 * Created by vilyever on 2015/9/15.
 * Feature:
 */
public class VDTimeUnit {
    private final VDTimeUnit self = this;

    long totalMilliseconds;

    public long milliseconds;
    public long seconds;
    public long minutes;
    public long hours;

    /* #Constructors */
    public VDTimeUnit() {
        this(0);
    }

    public VDTimeUnit(long totalMilliseconds) {
        setTotalMilliseconds(totalMilliseconds);
    }

    /* #Overrides */
    @Override
    public String toString() {
        return toString(VDTimeCategory.Hour, VDTimeCategory.Millisecond);
    }
    
    /* #Accessors */
    public long getTotalMilliseconds() {
        return totalMilliseconds;
    }

    public void setTotalMilliseconds(long totalMilliseconds) {
        this.totalMilliseconds = totalMilliseconds;

        this.milliseconds = totalMilliseconds % 1000;
        this.seconds = totalMilliseconds / 1000 % 60;
        this.milliseconds = totalMilliseconds / 1000 / 60 % 60;
        this.hours = totalMilliseconds / 1000 / 60 / 60;
    }
     
    /* #Delegates */     
     
    /* #Private Methods */    
    
    /* #Public Methods */
    public String toString(VDTimeCategory fromCategory, VDTimeCategory toCategory) {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < VDTimeCategory.values().length; i++) {
            if ((i >= fromCategory.ordinal() && i <= toCategory.ordinal())
                || (i <= fromCategory.ordinal() && i >= toCategory.ordinal())) {
                VDTimeCategory category = VDTimeCategory.values()[i];
                switch (category) {
                    case Hour:
                        builder.append(String.format("%02d", this.hours));
                        break;
                    case Minute:
                        if (builder.length() > 0) {
                            builder.append(":");
                        }
                        builder.append(String.format("%02d", this.minutes));
                        break;
                    case Second:
                        if (builder.length() > 0) {
                            builder.append(":");
                        }
                        builder.append(String.format("%02d", this.seconds));
                        break;
                    case Millisecond:
                        if (builder.length() > 0) {
                            builder.append(".");
                        }
                        builder.append(String.format("%03d", this.milliseconds));
                        break;
                }
            }
        }
        return builder.toString();
    }

    /* #Classes */

    /* #Interfaces */     
     
    /* #Annotations @interface */    
    
    /* #Enums */
    public enum VDTimeCategory {
        Hour, Minute, Second, Millisecond
    }
}