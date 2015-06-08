/*
 * Copyright (C) 2015 NS Solutions Corporation
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
package com.htmlhifive.testlib.it.screenshot.partialapge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.htmlhifive.testlib.core.MrtTestBase;
import com.htmlhifive.testlib.core.config.MrtTestConfig;
import com.htmlhifive.testlib.core.model.CompareTarget;
import com.htmlhifive.testlib.core.model.ScreenArea;
import com.htmlhifive.testlib.core.model.SelectorType;

/**
 * ページの特定要素のスクリーンショットが正しくとれているかのテスト
 */
public class TakeMultiplePartBySingleTargetTest extends MrtTestBase {

	private static final String BASE_URL = MrtTestConfig.getInstance().getTestAppConfig().getBaseUrl();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * 複数要素からなるターゲットを指定した時にスクリーンショットが正しくとれているかのテスト<br>
	 * 実行環境：IE7～11/FireFox/Chrome/Android 2.3, 4.0, 4.4/iOS 8.1<br>
	 * 期待結果：テストが正しく実行でき、スクリーンショットが正しくとれていることを目視で確認する
	 */
	@Test
	public void takeMultiplePartBySingleTarget() {
		driver.get(BASE_URL);
		List<CompareTarget> targets = new ArrayList<CompareTarget>();
		targets.add(new CompareTarget(ScreenArea.of(SelectorType.CSS_SELECTOR, "#news tr")));
		assertionView.assertView("multipleElements", targets);
	}

	/**
	 * 複数要素からなるターゲットを指定するが, indicesパラメータでそのうちの特定要素を明示する場合<br>
	 * 実行環境：IE7～11/FireFox/Chrome/Android 2.3, 4.0, 4.4/iOS 8.1<br>
	 * 期待結果：テストが正しく実行でき、スクリーンショットが正しくとれていることを目視で確認する<br>
	 * 　　　　　この場合、「2014/07/07」の更新履歴部分が取得される。
	 */
	@Ignore("indicesが未実装のため無視する")
	@Test
	public void takeOneOfMultiplePartBySingleTarget() {
		fail();
	}
}