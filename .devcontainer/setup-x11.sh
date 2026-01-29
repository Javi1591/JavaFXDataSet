#!/bin/bash

# Setup X11 forwarding for JavaFX applications in dev container
# Run this script on your HOST machine before rebuilding the container

echo "Setting up X11 forwarding..."

# Allow X11 connections from localhost
xhost +local:docker 2>/dev/null || xhost +local:root 2>/dev/null || echo "Note: xhost command not found. X11 forwarding may not work."

echo "X11 forwarding setup complete!"
echo ""
echo "Next steps:"
echo "1. Rebuild your dev container (Ctrl+Shift+P -> 'Dev Containers: Rebuild Container')"
echo "2. After rebuild, your JavaFX application should be able to display"
