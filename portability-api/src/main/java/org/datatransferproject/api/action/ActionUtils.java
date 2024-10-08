/*
 * Copyright 2018 The Data Transfer Project Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.datatransferproject.api.action;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.BaseEncoding;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import org.datatransferproject.types.common.models.DataVertical;

/** Helper functions for validating action related data. */
public final class ActionUtils {

  public static String encodeJobId(UUID jobId) {
    Preconditions.checkNotNull(jobId);
    return BaseEncoding.base64Url().encode(jobId.toString().getBytes(StandardCharsets.UTF_8));
  }

  public static UUID decodeJobId(String encodedJobId) {
    Preconditions.checkArgument(!Strings.isNullOrEmpty(encodedJobId));
    return UUID.fromString(new String(BaseEncoding.base64Url().decode(encodedJobId),
        StandardCharsets.UTF_8));
  }

  /** Determines whether the current service is a valid service for import.
   * @param transferDataType*/
  public static boolean isValidTransferDataType(DataVertical transferDataType) {
    return transferDataType != null;
  }
}
