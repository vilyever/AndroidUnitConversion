package com.vilyever.unitconversion;

/**
 * VDTimeUnit
 * AndroidUnitConversion <com.vilyever.vdunitconversion>
 * Created by vilyever on 2015/9/15.
 * Feature:
 */
public class VDTimeUnit {
    private final VDTimeUnit self = this;

    /* Constructors */
    public VDTimeUnit() {
        this(0);
    }

    public VDTimeUnit(long totalMilliseconds) {
        setTotalMilliseconds(totalMilliseconds);
    }

    /* Public Methods */
    /**
     * 转换时间为string
     * @param fromCategory 从哪个时间单位开始转换
     * @param toCategory 到哪个时间单位结束
     * @return 时间字符串
     */
    public String convertToString(VDTimeCategory fromCategory, VDTimeCategory toCategory) {
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

    /* Properties */
    /**
     * 总毫秒
     * 仅提供总毫秒设置来变更所有属性
     */
    private long totalMilliseconds;
    private VDTimeUnit setTotalMilliseconds(long totalMilliseconds) {
        this.totalMilliseconds = totalMilliseconds;

        self.setMilliseconds(totalMilliseconds % 1000);
        self.setSeconds(totalMilliseconds / 1000 % 60);
        self.setMinutes(totalMilliseconds / 1000 / 60 % 60);
        self.setHours(totalMilliseconds / 1000 / 60 / 60);
        return this;
    }
    private long getTotalMilliseconds() {
        return totalMilliseconds;
    }

    private long milliseconds;
    private VDTimeUnit setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
        return this;
    }
    public long getMilliseconds() {
        return milliseconds;
    }

    private long seconds;
    private VDTimeUnit setSeconds(long seconds) {
        this.seconds = seconds;
        return this;
    }
    public long getSeconds() {
        return seconds;
    }

    private long minutes;
    private VDTimeUnit setMinutes(long minutes) {
        this.minutes = minutes;
        return this;
    }
    public long getMinutes() {
        return minutes;
    }

    private long hours;
    private VDTimeUnit setHours(long hours) {
        this.hours = hours;
        return this;
    }
    public long getHours() {
        return hours;
    }

    /* Overrides */
    @Override
    public String toString() {
        return convertToString(VDTimeCategory.Hour, VDTimeCategory.Millisecond);
    }

    /* Enums */
    public enum VDTimeCategory {
        Hour, Minute, Second, Millisecond
    }
}