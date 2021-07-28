package com.peep.githubapitest.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0003\b\u00a2\u0001\b\u0086\b\u0018\u00002\u00020\u0001B\u00d1\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010\'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u00020\u0003\u0012\u0006\u00107\u001a\u00020\u0003\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u00020\u0003\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010;\u001a\u00020<\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010>\u001a\u00020<\u0012\u0006\u0010?\u001a\u00020\u0003\u0012\u0006\u0010@\u001a\u00020\b\u0012\u0006\u0010A\u001a\u00020\b\u0012\u0006\u0010B\u001a\u00020\b\u0012\u0006\u0010C\u001a\u00020\b\u0012\u0006\u0010D\u001a\u00020\b\u0012\u0006\u0010E\u001a\u00020<\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010G\u001a\u00020\b\u0012\u0006\u0010H\u001a\u00020\b\u0012\u0006\u0010I\u001a\u00020<\u0012\u0006\u0010J\u001a\u00020K\u0012\u0006\u0010L\u001a\u00020<\u0012\u0006\u0010M\u001a\u00020<\u0012\u0006\u0010N\u001a\u00020<\u0012\u0006\u0010O\u001a\u00020\u0003\u00a2\u0006\u0002\u0010PJ\n\u0010\u009f\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a0\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a2\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a3\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a4\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a5\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a6\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a7\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a8\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a9\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00aa\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00ab\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00ac\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00ae\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00af\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b0\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b1\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b2\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b3\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b4\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b5\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b6\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b7\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b8\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00b9\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00ba\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00bb\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00bc\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00bd\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00be\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00bf\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00c0\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00c1\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00c2\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00c3\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00c4\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00c5\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00c6\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00c7\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00c8\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00c9\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00ca\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00cb\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u00cc\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00cd\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00ce\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00cf\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u00d0\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\n\u0010\u00d1\u0001\u001a\u00020<H\u00c6\u0003J\n\u0010\u00d2\u0001\u001a\u00020<H\u00c6\u0003J\n\u0010\u00d3\u0001\u001a\u00020<H\u00c6\u0003J\n\u0010\u00d4\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00d5\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u00d6\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u00d7\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u00d8\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u00d9\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u00da\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u00db\u0001\u001a\u00020<H\u00c6\u0003J\f\u0010\u00dc\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\n\u0010\u00dd\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u00de\u0001\u001a\u00020\bH\u00c6\u0003J\n\u0010\u00df\u0001\u001a\u00020<H\u00c6\u0003J\n\u0010\u00e0\u0001\u001a\u00020KH\u00c6\u0003J\n\u0010\u00e1\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00e2\u0001\u001a\u00020<H\u00c6\u0003J\n\u0010\u00e3\u0001\u001a\u00020<H\u00c6\u0003J\n\u0010\u00e4\u0001\u001a\u00020<H\u00c6\u0003J\n\u0010\u00e5\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00e6\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00e7\u0001\u001a\u00020\bH\u00c6\u0003J\u00e8\u0005\u0010\u00e8\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00032\b\b\u0002\u00107\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020<2\b\b\u0002\u0010>\u001a\u00020<2\b\b\u0002\u0010?\u001a\u00020\u00032\b\b\u0002\u0010@\u001a\u00020\b2\b\b\u0002\u0010A\u001a\u00020\b2\b\b\u0002\u0010B\u001a\u00020\b2\b\b\u0002\u0010C\u001a\u00020\b2\b\b\u0002\u0010D\u001a\u00020\b2\b\b\u0002\u0010E\u001a\u00020<2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010G\u001a\u00020\b2\b\b\u0002\u0010H\u001a\u00020\b2\b\b\u0002\u0010I\u001a\u00020<2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020<2\b\b\u0002\u0010M\u001a\u00020<2\b\b\u0002\u0010N\u001a\u00020<2\b\b\u0002\u0010O\u001a\u00020\u0003H\u00c6\u0001J\u0015\u0010\u00e9\u0001\u001a\u00020\b2\t\u0010\u00ea\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u00eb\u0001\u001a\u00020<H\u00d6\u0001J\n\u0010\u00ec\u0001\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010*\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0011\u0010G\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010RR\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010RR\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010RR\u0011\u00108\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010RR\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010RR\u0011\u0010%\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010RR\u0011\u0010#\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010RR\u0011\u0010(\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010RR\u0011\u0010\'\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010RR\u0011\u0010 \u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010RR\u0011\u00103\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010RR\u0011\u0010O\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010RR\u0011\u00102\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010RR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u0010RR\u0011\u0010H\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010TR\u0011\u0010+\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010RR\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010RR\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u0010TR\u0011\u0010L\u001a\u00020<\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0011\u0010E\u001a\u00020<\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u0010hR\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bj\u0010RR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bk\u0010RR\u0011\u0010$\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bl\u0010RR\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bm\u0010RR\u0011\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bn\u0010RR\u0011\u00106\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010RR\u0011\u0010B\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bp\u0010TR\u0011\u0010@\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010TR\u0011\u0010D\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\br\u0010TR\u0011\u0010A\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bs\u0010TR\u0011\u0010C\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bt\u0010TR\u0013\u0010:\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bu\u0010RR\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bv\u0010RR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bw\u0010RR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bx\u0010RR\u0011\u0010&\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\by\u0010RR\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bz\u0010RR\u0011\u0010,\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b{\u0010RR\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b|\u0010RR\u0011\u00100\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b}\u0010RR\u0011\u0010?\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b~\u0010RR\u0011\u0010\u001e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010RR\u0013\u0010J\u001a\u00020K\u00a2\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0012\u0010)\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010RR\u0012\u0010.\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010RR\u0014\u0010F\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010RR\u0012\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010RR\u0012\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010RR\u0012\u0010/\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010RR\u0012\u0010M\u001a\u00020<\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010hR\u0012\u0010I\u001a\u00020<\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010hR\u0013\u0010\t\u001a\u00020\n\u00a2\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0012\u0010\u0007\u001a\u00020\b\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010TR\u0012\u0010-\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010RR\u0012\u00105\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010RR\u0012\u00101\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010RR\u0012\u0010;\u001a\u00020<\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010hR\u0012\u00107\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010RR\u0012\u0010=\u001a\u00020<\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010hR\u0012\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010RR\u0012\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010RR\u0012\u0010!\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010RR\u0012\u0010\"\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010RR\u0012\u00109\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0097\u0001\u0010RR\u0012\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010RR\u0012\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0099\u0001\u0010RR\u0012\u0010\u001c\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010RR\u0012\u00104\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010RR\u0012\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010RR\u0012\u0010N\u001a\u00020<\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009d\u0001\u0010hR\u0012\u0010>\u001a\u00020<\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010h\u00a8\u0006\u00ed\u0001"}, d2 = {"Lcom/peep/githubapitest/model/Repo;", "", "id", "", "node_id", "name", "full_name", "private", "", "owner", "Lcom/peep/githubapitest/model/Owner;", "html_url", "description", "fork", "url", "forks_url", "keys_url", "collaborators_url", "teams_url", "hooks_url", "issue_events_url", "events_url", "assignees_url", "branches_url", "tags_url", "blobs_url", "git_tags_url", "git_refs_url", "trees_url", "statuses_url", "languages_url", "stargazers_url", "contributors_url", "subscribers_url", "subscription_url", "commits_url", "git_commits_url", "comments_url", "issue_comment_url", "contents_url", "compare_url", "merges_url", "archive_url", "downloads_url", "issues_url", "pulls_url", "milestones_url", "notifications_url", "labels_url", "releases_url", "deployments_url", "created_at", "updated_at", "pushed_at", "git_url", "ssh_url", "clone_url", "svn_url", "homepage", "size", "", "stargazers_count", "watchers_count", "language", "has_issues", "has_projects", "has_downloads", "has_wiki", "has_pages", "forks_count", "mirror_url", "archived", "disabled", "open_issues_count", "license", "Lcom/peep/githubapitest/model/License;", "forks", "open_issues", "watchers", "default_branch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/peep/githubapitest/model/Owner;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;ZZZZZILjava/lang/String;ZZILcom/peep/githubapitest/model/License;IIILjava/lang/String;)V", "getArchive_url", "()Ljava/lang/String;", "getArchived", "()Z", "getAssignees_url", "getBlobs_url", "getBranches_url", "getClone_url", "getCollaborators_url", "getComments_url", "getCommits_url", "getCompare_url", "getContents_url", "getContributors_url", "getCreated_at", "getDefault_branch", "getDeployments_url", "getDescription", "getDisabled", "getDownloads_url", "getEvents_url", "getFork", "getForks", "()I", "getForks_count", "getForks_url", "getFull_name", "getGit_commits_url", "getGit_refs_url", "getGit_tags_url", "getGit_url", "getHas_downloads", "getHas_issues", "getHas_pages", "getHas_projects", "getHas_wiki", "getHomepage", "getHooks_url", "getHtml_url", "getId", "getIssue_comment_url", "getIssue_events_url", "getIssues_url", "getKeys_url", "getLabels_url", "getLanguage", "getLanguages_url", "getLicense", "()Lcom/peep/githubapitest/model/License;", "getMerges_url", "getMilestones_url", "getMirror_url", "getName", "getNode_id", "getNotifications_url", "getOpen_issues", "getOpen_issues_count", "getOwner", "()Lcom/peep/githubapitest/model/Owner;", "getPrivate", "getPulls_url", "getPushed_at", "getReleases_url", "getSize", "getSsh_url", "getStargazers_count", "getStargazers_url", "getStatuses_url", "getSubscribers_url", "getSubscription_url", "getSvn_url", "getTags_url", "getTeams_url", "getTrees_url", "getUpdated_at", "getUrl", "getWatchers", "getWatchers_count", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Repo {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String node_id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String full_name = null;
    @org.jetbrains.annotations.NotNull()
    private final com.peep.githubapitest.model.Owner owner = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String html_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    private final boolean fork = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String forks_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String keys_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String collaborators_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String teams_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String hooks_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String issue_events_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String events_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String assignees_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String branches_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tags_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String blobs_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String git_tags_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String git_refs_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String trees_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String statuses_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String languages_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String stargazers_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contributors_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String subscribers_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String subscription_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String commits_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String git_commits_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String comments_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String issue_comment_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contents_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String compare_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String merges_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String archive_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String downloads_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String issues_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pulls_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String milestones_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String notifications_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String labels_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String releases_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String deployments_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String created_at = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String updated_at = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pushed_at = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String git_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ssh_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String clone_url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String svn_url = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String homepage = null;
    private final int size = 0;
    private final int stargazers_count = 0;
    private final int watchers_count = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String language = null;
    private final boolean has_issues = false;
    private final boolean has_projects = false;
    private final boolean has_downloads = false;
    private final boolean has_wiki = false;
    private final boolean has_pages = false;
    private final int forks_count = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String mirror_url = null;
    private final boolean archived = false;
    private final boolean disabled = false;
    private final int open_issues_count = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.peep.githubapitest.model.License license = null;
    private final int forks = 0;
    private final int open_issues = 0;
    private final int watchers = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String default_branch = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.peep.githubapitest.model.Repo copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String node_id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String full_name, boolean p4_1990234817, @org.jetbrains.annotations.NotNull()
    com.peep.githubapitest.model.Owner owner, @org.jetbrains.annotations.NotNull()
    java.lang.String html_url, @org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean fork, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String forks_url, @org.jetbrains.annotations.NotNull()
    java.lang.String keys_url, @org.jetbrains.annotations.NotNull()
    java.lang.String collaborators_url, @org.jetbrains.annotations.NotNull()
    java.lang.String teams_url, @org.jetbrains.annotations.NotNull()
    java.lang.String hooks_url, @org.jetbrains.annotations.NotNull()
    java.lang.String issue_events_url, @org.jetbrains.annotations.NotNull()
    java.lang.String events_url, @org.jetbrains.annotations.NotNull()
    java.lang.String assignees_url, @org.jetbrains.annotations.NotNull()
    java.lang.String branches_url, @org.jetbrains.annotations.NotNull()
    java.lang.String tags_url, @org.jetbrains.annotations.NotNull()
    java.lang.String blobs_url, @org.jetbrains.annotations.NotNull()
    java.lang.String git_tags_url, @org.jetbrains.annotations.NotNull()
    java.lang.String git_refs_url, @org.jetbrains.annotations.NotNull()
    java.lang.String trees_url, @org.jetbrains.annotations.NotNull()
    java.lang.String statuses_url, @org.jetbrains.annotations.NotNull()
    java.lang.String languages_url, @org.jetbrains.annotations.NotNull()
    java.lang.String stargazers_url, @org.jetbrains.annotations.NotNull()
    java.lang.String contributors_url, @org.jetbrains.annotations.NotNull()
    java.lang.String subscribers_url, @org.jetbrains.annotations.NotNull()
    java.lang.String subscription_url, @org.jetbrains.annotations.NotNull()
    java.lang.String commits_url, @org.jetbrains.annotations.NotNull()
    java.lang.String git_commits_url, @org.jetbrains.annotations.NotNull()
    java.lang.String comments_url, @org.jetbrains.annotations.NotNull()
    java.lang.String issue_comment_url, @org.jetbrains.annotations.NotNull()
    java.lang.String contents_url, @org.jetbrains.annotations.NotNull()
    java.lang.String compare_url, @org.jetbrains.annotations.NotNull()
    java.lang.String merges_url, @org.jetbrains.annotations.NotNull()
    java.lang.String archive_url, @org.jetbrains.annotations.NotNull()
    java.lang.String downloads_url, @org.jetbrains.annotations.NotNull()
    java.lang.String issues_url, @org.jetbrains.annotations.NotNull()
    java.lang.String pulls_url, @org.jetbrains.annotations.NotNull()
    java.lang.String milestones_url, @org.jetbrains.annotations.NotNull()
    java.lang.String notifications_url, @org.jetbrains.annotations.NotNull()
    java.lang.String labels_url, @org.jetbrains.annotations.NotNull()
    java.lang.String releases_url, @org.jetbrains.annotations.NotNull()
    java.lang.String deployments_url, @org.jetbrains.annotations.NotNull()
    java.lang.String created_at, @org.jetbrains.annotations.NotNull()
    java.lang.String updated_at, @org.jetbrains.annotations.NotNull()
    java.lang.String pushed_at, @org.jetbrains.annotations.NotNull()
    java.lang.String git_url, @org.jetbrains.annotations.NotNull()
    java.lang.String ssh_url, @org.jetbrains.annotations.NotNull()
    java.lang.String clone_url, @org.jetbrains.annotations.NotNull()
    java.lang.String svn_url, @org.jetbrains.annotations.Nullable()
    java.lang.String homepage, int size, int stargazers_count, int watchers_count, @org.jetbrains.annotations.NotNull()
    java.lang.String language, boolean has_issues, boolean has_projects, boolean has_downloads, boolean has_wiki, boolean has_pages, int forks_count, @org.jetbrains.annotations.Nullable()
    java.lang.String mirror_url, boolean archived, boolean disabled, int open_issues_count, @org.jetbrains.annotations.NotNull()
    com.peep.githubapitest.model.License license, int forks, int open_issues, int watchers, @org.jetbrains.annotations.NotNull()
    java.lang.String default_branch) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Repo(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String node_id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String full_name, boolean p4_1990234817, @org.jetbrains.annotations.NotNull()
    com.peep.githubapitest.model.Owner owner, @org.jetbrains.annotations.NotNull()
    java.lang.String html_url, @org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean fork, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String forks_url, @org.jetbrains.annotations.NotNull()
    java.lang.String keys_url, @org.jetbrains.annotations.NotNull()
    java.lang.String collaborators_url, @org.jetbrains.annotations.NotNull()
    java.lang.String teams_url, @org.jetbrains.annotations.NotNull()
    java.lang.String hooks_url, @org.jetbrains.annotations.NotNull()
    java.lang.String issue_events_url, @org.jetbrains.annotations.NotNull()
    java.lang.String events_url, @org.jetbrains.annotations.NotNull()
    java.lang.String assignees_url, @org.jetbrains.annotations.NotNull()
    java.lang.String branches_url, @org.jetbrains.annotations.NotNull()
    java.lang.String tags_url, @org.jetbrains.annotations.NotNull()
    java.lang.String blobs_url, @org.jetbrains.annotations.NotNull()
    java.lang.String git_tags_url, @org.jetbrains.annotations.NotNull()
    java.lang.String git_refs_url, @org.jetbrains.annotations.NotNull()
    java.lang.String trees_url, @org.jetbrains.annotations.NotNull()
    java.lang.String statuses_url, @org.jetbrains.annotations.NotNull()
    java.lang.String languages_url, @org.jetbrains.annotations.NotNull()
    java.lang.String stargazers_url, @org.jetbrains.annotations.NotNull()
    java.lang.String contributors_url, @org.jetbrains.annotations.NotNull()
    java.lang.String subscribers_url, @org.jetbrains.annotations.NotNull()
    java.lang.String subscription_url, @org.jetbrains.annotations.NotNull()
    java.lang.String commits_url, @org.jetbrains.annotations.NotNull()
    java.lang.String git_commits_url, @org.jetbrains.annotations.NotNull()
    java.lang.String comments_url, @org.jetbrains.annotations.NotNull()
    java.lang.String issue_comment_url, @org.jetbrains.annotations.NotNull()
    java.lang.String contents_url, @org.jetbrains.annotations.NotNull()
    java.lang.String compare_url, @org.jetbrains.annotations.NotNull()
    java.lang.String merges_url, @org.jetbrains.annotations.NotNull()
    java.lang.String archive_url, @org.jetbrains.annotations.NotNull()
    java.lang.String downloads_url, @org.jetbrains.annotations.NotNull()
    java.lang.String issues_url, @org.jetbrains.annotations.NotNull()
    java.lang.String pulls_url, @org.jetbrains.annotations.NotNull()
    java.lang.String milestones_url, @org.jetbrains.annotations.NotNull()
    java.lang.String notifications_url, @org.jetbrains.annotations.NotNull()
    java.lang.String labels_url, @org.jetbrains.annotations.NotNull()
    java.lang.String releases_url, @org.jetbrains.annotations.NotNull()
    java.lang.String deployments_url, @org.jetbrains.annotations.NotNull()
    java.lang.String created_at, @org.jetbrains.annotations.NotNull()
    java.lang.String updated_at, @org.jetbrains.annotations.NotNull()
    java.lang.String pushed_at, @org.jetbrains.annotations.NotNull()
    java.lang.String git_url, @org.jetbrains.annotations.NotNull()
    java.lang.String ssh_url, @org.jetbrains.annotations.NotNull()
    java.lang.String clone_url, @org.jetbrains.annotations.NotNull()
    java.lang.String svn_url, @org.jetbrains.annotations.Nullable()
    java.lang.String homepage, int size, int stargazers_count, int watchers_count, @org.jetbrains.annotations.NotNull()
    java.lang.String language, boolean has_issues, boolean has_projects, boolean has_downloads, boolean has_wiki, boolean has_pages, int forks_count, @org.jetbrains.annotations.Nullable()
    java.lang.String mirror_url, boolean archived, boolean disabled, int open_issues_count, @org.jetbrains.annotations.NotNull()
    com.peep.githubapitest.model.License license, int forks, int open_issues, int watchers, @org.jetbrains.annotations.NotNull()
    java.lang.String default_branch) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNode_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFull_name() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getPrivate() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.peep.githubapitest.model.Owner component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.peep.githubapitest.model.Owner getOwner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHtml_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getFork() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getForks_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKeys_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCollaborators_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTeams_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHooks_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIssue_events_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEvents_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAssignees_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBranches_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTags_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBlobs_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGit_tags_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGit_refs_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTrees_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatuses_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguages_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStargazers_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContributors_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubscribers_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubscription_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCommits_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component32() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGit_commits_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component33() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getComments_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component34() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIssue_comment_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component35() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContents_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component36() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompare_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component37() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMerges_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component38() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getArchive_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component39() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDownloads_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component40() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIssues_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component41() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPulls_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component42() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMilestones_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component43() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNotifications_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component44() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabels_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component45() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReleases_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component46() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeployments_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component47() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreated_at() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component48() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdated_at() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component49() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPushed_at() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component50() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGit_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component51() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSsh_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component52() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClone_url() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component53() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSvn_url() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component54() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHomepage() {
        return null;
    }
    
    public final int component55() {
        return 0;
    }
    
    public final int getSize() {
        return 0;
    }
    
    public final int component56() {
        return 0;
    }
    
    public final int getStargazers_count() {
        return 0;
    }
    
    public final int component57() {
        return 0;
    }
    
    public final int getWatchers_count() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component58() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final boolean component59() {
        return false;
    }
    
    public final boolean getHas_issues() {
        return false;
    }
    
    public final boolean component60() {
        return false;
    }
    
    public final boolean getHas_projects() {
        return false;
    }
    
    public final boolean component61() {
        return false;
    }
    
    public final boolean getHas_downloads() {
        return false;
    }
    
    public final boolean component62() {
        return false;
    }
    
    public final boolean getHas_wiki() {
        return false;
    }
    
    public final boolean component63() {
        return false;
    }
    
    public final boolean getHas_pages() {
        return false;
    }
    
    public final int component64() {
        return 0;
    }
    
    public final int getForks_count() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component65() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMirror_url() {
        return null;
    }
    
    public final boolean component66() {
        return false;
    }
    
    public final boolean getArchived() {
        return false;
    }
    
    public final boolean component67() {
        return false;
    }
    
    public final boolean getDisabled() {
        return false;
    }
    
    public final int component68() {
        return 0;
    }
    
    public final int getOpen_issues_count() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.peep.githubapitest.model.License component69() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.peep.githubapitest.model.License getLicense() {
        return null;
    }
    
    public final int component70() {
        return 0;
    }
    
    public final int getForks() {
        return 0;
    }
    
    public final int component71() {
        return 0;
    }
    
    public final int getOpen_issues() {
        return 0;
    }
    
    public final int component72() {
        return 0;
    }
    
    public final int getWatchers() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component73() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDefault_branch() {
        return null;
    }
}