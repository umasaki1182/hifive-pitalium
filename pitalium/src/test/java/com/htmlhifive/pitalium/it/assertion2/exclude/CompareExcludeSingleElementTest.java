/*
 * Copyright (C) 2015-2017 NS Solutions Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.htmlhifive.pitalium.it.assertion2.exclude;

import com.htmlhifive.pitalium.core.model.ScreenshotArgument;
import com.htmlhifive.pitalium.it.assertion2.PtlItAssertionTestBase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.fail;

/**
 * 単一要素を撮影時に除外設定をするテスト
 */
public class CompareExcludeSingleElementTest extends PtlItAssertionTestBase {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void compareChangedElementWithoutExcludeOption() throws Exception {
		openBasicTextPage(true);

		ScreenshotArgument arg = ScreenshotArgument.builder("s").addNewTargetById("textColumn0").build();

		if (isRunTest()) {
			expectedException.expect(AssertionError.class);
			assertionView.assertView(arg);
			fail();
			return;
		}

		assertionView.assertView(arg);
	}

	@Test
	public void compareNotChangedElementWithExcludeOption() throws Exception {
		openBasicTextPage(false);

		ScreenshotArgument arg = ScreenshotArgument.builder("s").addNewTargetById("textColumn0")
				.addExcludeByCssSelector("h2").build();

		assertionView.assertView(arg);
	}

	@Test
	public void compareChangedElementWithExcludeOption() throws Exception {
		openBasicTextPage(true);

		ScreenshotArgument arg = ScreenshotArgument.builder("s").addNewTargetById("textColumn0")
				.addExcludeByCssSelector("h2").build();

		assertionView.assertView(arg);
	}

}