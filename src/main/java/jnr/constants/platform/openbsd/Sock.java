// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated Wed Feb 25 18:33:20 +1000 2009
package jnr.constants.platform.openbsd;
public enum Sock implements jnr.constants.Constant {
SOCK_STREAM(1),
SOCK_DGRAM(2),
SOCK_RAW(3),
SOCK_RDM(4),
SOCK_SEQPACKET(5);
// SOCK_MAXADDRLEN not defined
private final int value;
private Sock(int value) { this.value = value; }
public static final long MIN_VALUE = 1;
public static final long MAX_VALUE = 5;

public final int value() { return value; }
public final int intValue() { return value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
