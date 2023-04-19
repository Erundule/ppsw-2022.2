package br.upe.ppsw.jabberpoint.model;

import java.io.IOException;

public interface FileSaver {
	abstract public void saveFile(Presentation presentation, String fileName) throws IOException;
}
