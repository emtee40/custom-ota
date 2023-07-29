/*
 * Copyright (C) 2023  Andrew Gunnerson
 *
 * SPDX-License-Identifier: GPL-3.0-only
 */

package com.chiller3.custota.extension

fun Throwable.toSingleLineString() = buildString {
    var current: Throwable? = this@toSingleLineString
    var first = true

    while (current != null) {
        if (first) {
            first = false
        } else {
            append(" -> ")
        }

        append(current.javaClass.simpleName)

        val message = current.localizedMessage
        if (!message.isNullOrBlank()) {
            append(" (")
            append(message)
            append(")")
        }

        current = current.cause
    }
}
