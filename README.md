# AndroidUnitConversion
Android转换单位dp,sp,px.

时间转换

## Import
[JitPack](https://jitpack.io/)

Add it in your project's build.gradle at the end of repositories:

```gradle
repositories {
  // ...
  maven { url "https://jitpack.io" }
}
```

Step 2. Add the dependency in the form

```gradle
dependencies {
  compile 'com.github.vilyever:AndroidUnitConversion:1.0.3'
}
```

## Usage
```java

System.out.println("from Milliseconds to Minutes " + TimeConverter.convertMillisecondsToMinutes(41891564l));
System.out.println("from Milliseconds to String " + TimeConverter.convertMillisecondsToString(41891564l, TimeConverter.TimeUnits.Hour, TimeConverter.TimeUnits.Millisecond));
System.out.println("from Milliseconds to String  " + TimeConverter.convertMillisecondsToString(41891564l, TimeConverter.TimeUnits.Hour, TimeConverter.TimeUnits.Millisecond));

int px = DimenConverter.dpToPixel(18);
int dp = DimenConverter.pixelToDp(px);
System.out.println("px " + px + " : dp " + dp);
px = DimenConverter.spToPixel(20);
int sp = DimenConverter.pixelToSp(px);
System.out.println("px " + px + " : sp " + sp);
```

## License
[Apache License Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)

