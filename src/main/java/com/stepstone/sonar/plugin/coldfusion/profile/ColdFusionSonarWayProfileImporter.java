/*
Copyright 2016 StepStone GmbH

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.stepstone.sonar.plugin.coldfusion.profile;

import com.google.common.base.Charsets;
import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.utils.ValidationMessages;

import java.io.InputStreamReader;

public class ColdFusionSonarWayProfileImporter extends ProfileDefinition {

    private static final String DEFAULT_PROFILE_PATH = "/com/stepstone/sonar/plugin/coldfusion/profile.xml";

    private final XMLProfileParser xmlParser;

    public ColdFusionSonarWayProfileImporter(XMLProfileParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    @Override
    public RulesProfile createProfile(ValidationMessages validation) {
        return xmlParser.parse(new InputStreamReader(getClass().getResourceAsStream(DEFAULT_PROFILE_PATH), Charsets.UTF_8), validation);
    }

}
