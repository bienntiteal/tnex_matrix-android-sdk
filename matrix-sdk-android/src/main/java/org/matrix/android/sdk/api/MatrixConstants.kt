/*
 * Copyright (c) 2021 The Matrix.org Foundation C.I.C.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.android.sdk.api

/**
 * This object define some global constants regarding the Matrix specification
 */
object MatrixConstants {
    /**
     * Max length for an alias. Room aliases MUST NOT exceed 255 bytes (including the # sigil and the domain).
     * See [maxAliasLocalPartLength]
     * Ref. https://matrix.org/docs/spec/appendices#room-aliases
     */
    const val ALIAS_MAX_LENGTH = 255

    fun maxAliasLocalPartLength(domain: String): Int {
        return (ALIAS_MAX_LENGTH - 1 /* # sigil */ - 1 /* ':' */ - domain.length)
                .coerceAtLeast(0)
    }

    private var uploadUrl : String = ""
    private var userDeviceId : String = ""
    private var userUploadToken : String =  ""
    private var userLocation : String = ""
    private var userLanguage : String = ""

    fun updateUploadInfo(userDeviceId : String, userUploadToken : String, userLocation : String, userLanguage : String){
        this.userDeviceId = userDeviceId
        this.userUploadToken = userUploadToken
        this.userLanguage = userLanguage
        this.userLocation = userLocation
    }

    fun updateUserUploadToken(uploadUrl : String){
        this.uploadUrl = uploadUrl
    }

    fun setUploadUrl(uploadUrl : String){
        this.uploadUrl = uploadUrl
    }

    fun getUploadUrl():String{
        return uploadUrl
    }

    fun getUserDeviceId():String{
        return userDeviceId
    }

    fun getUserUploadToken():String{
        return userUploadToken
    }

    fun getUserLocation():String{
        return userLocation
    }

    fun getUserLanguage():String{
        return userLanguage
    }
}
