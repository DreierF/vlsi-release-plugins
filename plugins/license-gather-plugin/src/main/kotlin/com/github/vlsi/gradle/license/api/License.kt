/*
 * Copyright 2019 Vladimir Sitnikov <sitnikov.vladimir@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.vlsi.gradle.license.api

import java.net.URI

interface License {
    val title: String
    val uri: List<URI>
}

interface LicenseException {
    val title: String
    val uri: List<URI>
}

data class SimpleLicense(override val title: String, override val uri: List<URI>) :
    License {
    constructor(title: String, uri: URI? = null) : this(title, if (uri == null) emptyList() else listOf(uri))
}

data class SimpleException(override val title: String, override val uri: List<URI>) :
    LicenseException {
    constructor(title: String, uri: URI? = null) : this(title, if (uri == null) emptyList() else listOf(uri))
}

interface StandardLicense : License {
    val providerId: String
    val id: String
}

interface StandardLicenseException : LicenseException {
    val providerId: String
    val id: String
}