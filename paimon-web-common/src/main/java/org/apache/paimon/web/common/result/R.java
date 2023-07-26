/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.paimon.web.common.result;

import org.apache.paimon.web.common.enums.Status;

import lombok.Data;

/** result. */
@Data
public class R<T> {
    /** result code. */
    private final int code;
    /** result msg. */
    private final String msg;
    /** result data. */
    private final T data;

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> of(T data, int code, String msg) {
        return new R<>(code, msg, data);
    }

    public static <T> R<T> of(T data, int code, Status status) {
        return new R<>(code, status.getMsg(), data);
    }

    public static <T> R<T> succeed() {
        return of(null, Status.SUCCESS.getCode(), Status.SUCCESS.getMsg());
    }

    public static <T> R<T> succeed(T data) {
        return of(data, Status.SUCCESS.getCode(), Status.SUCCESS.getMsg());
    }

    public static <T> R<T> failed() {
        return of(null, Status.FAILED.getCode(), Status.FAILED.getMsg());
    }

    public static <T> R<T> failed(Status status) {
        return of(null, status.getCode(), status.getMsg());
    }

    public static <T> R<T> failed(T data) {
        return of(data, Status.FAILED.getCode(), Status.FAILED.getMsg());
    }
}
