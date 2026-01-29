# X11 Forwarding Setup for JavaFX

This configuration enables X11 forwarding so JavaFX applications can display GUI windows from within the dev container.

## Prerequisites

- Docker Desktop or Docker Engine running on your host machine
- X11 server running on your host:
  - **Linux**: X11 is usually pre-installed
  - **macOS**: Install [XQuartz](https://www.xquartz.org/)
  - **Windows**: Install [VcXsrv](https://sourceforge.net/projects/vcxsrv/) or [Xming](https://sourceforge.net/projects/xming/)

## Setup Instructions

### Linux Host

1. On your **host machine** (not in the container), run:
   ```bash
   xhost +local:docker
   ```

2. In VS Code, rebuild the container:
   - Press `Ctrl+Shift+P` (or `Cmd+Shift+P` on Mac)
   - Select "Dev Containers: Rebuild Container"

3. After rebuild, run your JavaFX application

### macOS Host

1. Install XQuartz from https://www.xquartz.org/

2. Open XQuartz preferences:
   - Go to Preferences → Security
   - Enable "Allow connections from network clients"

3. Restart XQuartz

4. In a terminal on your host, run:
   ```bash
   xhost +localhost
   ```

5. Set DISPLAY variable (if not already set):
   ```bash
   export DISPLAY=host.docker.internal:0
   ```

6. Rebuild the container in VS Code

### Windows Host

1. Install VcXsrv from https://sourceforge.net/projects/vcxsrv/

2. Launch XLaunch with these settings:
   - Display settings: Multiple windows
   - Start no client
   - Extra settings: Disable access control ✓

3. In Windows PowerShell, set DISPLAY:
   ```powershell
   $env:DISPLAY = "host.docker.internal:0"
   ```

4. Rebuild the container in VS Code

## Running the JavaFX Application

After setup, compile and run:

```bash
cd /workspaces/JavaFXDataSet/nazario19/nazario19

# Compile
javac --module-path /usr/share/openjfx/lib \
      --add-modules javafx.controls,javafx.fxml \
      -d bin src/module-info.java src/chapter19/*.java

# Run
java --module-path /usr/share/openjfx/lib:bin \
     --add-modules javafx.controls,javafx.fxml,java.sql \
     -m chapter19/chapter19.DataSetGenericFX
```

## Troubleshooting

### Error: "No toolkit found"
- Ensure X11 server is running on your host
- Verify DISPLAY variable is set: `echo $DISPLAY`
- Check X11 permissions: Run `xhost +local:docker` on host

### Error: "Can't open display"
- Verify X11 socket is mounted: `ls /tmp/.X11-unix`
- On Linux, try: `export DISPLAY=:0`
- On macOS/Windows, try: `export DISPLAY=host.docker.internal:0`

### Black screen or frozen window
- Some X11 configurations may have rendering issues
- Try different X11 server settings
