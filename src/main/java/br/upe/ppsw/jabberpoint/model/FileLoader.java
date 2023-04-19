package br.upe.ppsw.jabberpoint.model;


import java.io.IOException;

public interface FileLoader {
	public void loadFile(Presentation presentation, String fileName) throws IOException;
}
