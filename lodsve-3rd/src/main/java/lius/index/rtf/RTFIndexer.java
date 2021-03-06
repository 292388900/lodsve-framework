package lius.index.rtf;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

import lius.config.LiusField;
import lius.index.Indexer;

import org.apache.log4j.Logger;


/**
 * Classe permettant d'indexer des fichiers RTF. <br/><br/> Class that indexes
 * RTF files.
 *
 * @author Rida Benjelloun (ridabenjelloun@gmail.com)
 */

public class RTFIndexer extends Indexer {

	static Logger logger = Logger.getRootLogger();

	public int getType() {
		return 1;
	}

	public boolean isConfigured() {
		boolean ef = false;
		if (getLiusConfig().getRtfFields() != null)
			return ef = true;
		return ef;
	}

	public Collection getConfigurationFields() {
		return getLiusConfig().getRtfFields();
	}

	public String getContent() {
		String content = "";
		try {
			DefaultStyledDocument sd = new DefaultStyledDocument();
			RTFEditorKit kit = new RTFEditorKit();
			kit.read(getStreamToIndex(), sd, 0);
			content = sd.getText(0, sd.getLength());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (BadLocationException j) {
			logger.error(j.getMessage());
		}
		return content;
	}

	/**
	 * Retourne une collection contenant les champs avec les valeurs à indexer
	 * comme par exemple : le texte integral, titre etc. <br/><br/> Returns a
	 * collection containing the fields with the values to index like : full
	 * text, title, etc.
	 */

	public Collection getPopulatedLiusFields() {
		Collection coll = new ArrayList();
		Iterator it = getLiusConfig().getRtfFields().iterator();
		while (it.hasNext()) {
			Object field = it.next();
			if (field instanceof LiusField) {
				LiusField lf = (LiusField) field;
				if (lf.getGet() != null) {
					if (lf.getGet().equalsIgnoreCase("content")) {
						String text = getContent();
						lf.setValue(text);
						coll.add(lf);
					}
				}
			} else {
				coll.add(field);
			}
		}
		return coll;
	}

}