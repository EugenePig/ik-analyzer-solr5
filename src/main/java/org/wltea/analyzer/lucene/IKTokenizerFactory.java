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
package org.wltea.analyzer.lucene;

import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

/**
 * @author <a href="mailto:su.eugene@gmail.com">Eugene Su</a>
 */
public class IKTokenizerFactory extends TokenizerFactory{
  private boolean useSmart;
	
  public boolean useSmart() {
	return useSmart;
  }
	
  public void setUseSmart(boolean useSmart) {
    this.useSmart = useSmart;
  }
	
  public IKTokenizerFactory(Map<String,String> args) {
    super(args);
    String  useSmartArg = args.get("useSmart");
    this.setUseSmart(useSmartArg != null ? Boolean.parseBoolean(useSmartArg) : false);
  }
  
  @Override
  public Tokenizer create(AttributeFactory factory) {
    Tokenizer _IKTokenizer = new IKTokenizer(factory , this.useSmart);
    return _IKTokenizer;
  }
}