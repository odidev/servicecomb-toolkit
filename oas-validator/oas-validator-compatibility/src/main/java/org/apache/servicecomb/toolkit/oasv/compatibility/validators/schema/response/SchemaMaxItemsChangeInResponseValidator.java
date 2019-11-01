/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.toolkit.oasv.compatibility.validators.schema.response;

import org.apache.servicecomb.toolkit.oasv.diffvalidation.api.DiffViolationMessages;
import org.apache.servicecomb.toolkit.oasv.diffvalidation.api.OasDiffValidationContext;
import org.apache.servicecomb.toolkit.oasv.compatibility.validators.schema.SchemaPropertyChangeValidator;
import io.swagger.v3.oas.models.media.Schema;

import static org.apache.servicecomb.toolkit.oasv.diffvalidation.util.OasDiffValidationContextUtils.*;

public class SchemaMaxItemsChangeInResponseValidator extends SchemaPropertyChangeValidator<Integer> {

  @Override
  protected Integer getProperty(Schema schema) {
    return schema.getMaxItems();
  }

  @Override
  protected String getPropertyName() {
    return "maxItems";
  }

  @Override
  protected boolean isAllowed(Integer leftProperty, Integer rightProperty) {
    return rightProperty.compareTo(leftProperty) <= 0;
  }

  @Override
  protected String getMessage(Integer leftProperty, Integer rightProperty) {
    return DiffViolationMessages.NEW_NOT_LTE_OLD;
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInResponse(context);
  }

}