// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated Wed Feb 25 18:33:16 +1000 2009
package jnr.constants.platform.openbsd;
public enum RLIMIT implements jnr.constants.Constant {
RLIMIT_CORE(4),
// RLIMIT_AS not defined
RLIMIT_CPU(0),
RLIMIT_DATA(2),
RLIMIT_FSIZE(1),
// RLIMIT_LOCKS not defined
RLIMIT_MEMLOCK(6),
// RLIMIT_MSGQUEUE not defined
// RLIMIT_NICE not defined
// RLIMIT_NLIMITS not defined
RLIMIT_NOFILE(8),
RLIMIT_NPROC(7),
// RLIMIT_OFILE not defined
RLIMIT_RSS(5),
// RLIMIT_RTPRIO not defined
// RLIMIT_RTTIME not defined
// RLIMIT_SIGPENDING not defined
RLIMIT_STACK(3);
private final int value;
private RLIMIT(int value) { this.value = value; }
public static final long MIN_VALUE = 0;
public static final long MAX_VALUE = 8;

public final int value() { return value; }
public final int intValue() { return value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
