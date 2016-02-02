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
  compile 'com.github.vilyever:AndroidUnitConversion:1.0.2'
}
```

## Usage
```java

VDTimeUnit timeUnit = new VDTimeUnit(41891564);
System.out.println("time " + timeUnit);
System.out.println("time " + timeUnit.toString(VDTimeUnit.VDTimeCategory.Hour, VDTimeUnit.VDTimeCategory.Millisecond));
System.out.println("time " + timeUnit.toString(VDTimeUnit.VDTimeCategory.Second, VDTimeUnit.VDTimeCategory.Hour));

int px = VDDimenConversion.dpToPixel(18);
int dp = VDDimenConversion.pixelToDp(18);
px = VDDimenConversion.spToPixel(18);
int sp = VDDimenConversion.pixelToSp(18);
```

## License
[Apache License Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)

