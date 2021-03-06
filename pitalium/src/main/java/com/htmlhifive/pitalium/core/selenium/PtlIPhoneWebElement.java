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
package com.htmlhifive.pitalium.core.selenium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * iPhoneで利用する{@link org.openqa.selenium.WebElement}
 */
class PtlIPhoneWebElement extends PtlWebElement {
	private static final Logger LOG = LoggerFactory.getLogger(PtlIPhoneWebElement.class);

	@Override
	public int scrollNext() throws InterruptedException {
		long initialScrollTop = (int) Math.round(getCurrentScrollTop());
		long clientHeight = getClientHeight();
		LOG.debug("[Scroll element] next to ({}, {}) ({})", 0, initialScrollTop + clientHeight, this);
		// 外枠の影を切り取るのでスクロール量を減らす
		scrollTo(0, initialScrollTop + clientHeight - 3);
		long currentScrollTop = (int) Math.round(getCurrentScrollTop());
		return (int) (currentScrollTop - initialScrollTop);
	}
}
